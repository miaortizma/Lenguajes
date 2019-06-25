package interpreter;

import gen.SLGrammarParser.*;
import gen.SLGrammarParserBaseVisitor;
import interpreter.assignables.*;
import interpreter.factories.AbstractFactory;
import interpreter.factories.DefaultFactory;
import interpreter.factories.RecordFactory;
import interpreter.factories.TensorFactory;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

interface Access {
}

class TensorAccess implements Access {
    int[] pos;

    public TensorAccess(int[] pos) {
        this.pos = pos;
    }
}


class RecordAccess implements Access {
    String name;

    public RecordAccess(String name) {
        this.name = name;
    }
}

class Parameter {
    Assignable assig;
    String id;

    public Parameter(Assignable assig) {
        this.assig = assig;
        id = null;
    }

    public Parameter(Assignable assig, String id) {
        this.assig = assig;
        this.id = id;
    }
}

class FormalParameter {
    AbstractFactory factory;
    String name;
    boolean isRef;

    public FormalParameter(AbstractFactory factory, String name, boolean isRef) {
        this.factory = factory;
        this.name = name;
        this.isRef = isRef;
    }
}
// mirar ejemplo https://jakubdziworski.github.io/java/2016/04/01/antlr_visitor_vs_listener.html

public class MyVisitor<T> extends SLGrammarParserBaseVisitor<T> {
    StackedContextMap table = new StackedContextMap();
    ExpressionVisitor expressionVisitor = new ExpressionVisitor();
    TypeVisitor typeVisitor = new TypeVisitor();
    Access_variableVisitor accessVariableVisitor = new Access_variableVisitor();
    Access_tensorVisitor accessTensorVisitor = new Access_tensorVisitor();
    Access_recordVisitor accessRecordVisitor = new Access_recordVisitor();
    ParametersVisitor parametersVisitor = new ParametersVisitor();
    DataTypeVisitor dataTypeVisitor = new DataTypeVisitor();
    LiteralVisitor literalVisitor = new LiteralVisitor();

    @Override
    public T visitProgram(ProgramContext ctx) {
        //añadir declaraciones globales (CONSTS, VARIABLES, TIPOS)
        if (ctx.declarations() != null)
            this.visit(ctx.declarations());

        SubroutinesContext subs = ctx.subroutines();
        if (subs != null)
            for (SubroutineContext subroutine : subs.subroutine()) {
                String str = subroutine.ID().getText();
                table.putConst(str, new Subroutine(subroutine));
            }
        //añadir funciones a el ámbito de variables
        if (ctx.sentences() != null)
            this.visitSentences(ctx.sentences());

        return null;
    }

    private void validateExists(String name) {
        if (!table.has(name))
            throw new RuntimeException("Identifier doesn't exists: " + name);
    }

    private void validateFree(String name) {
        if (table.has(name))
            throw new RuntimeException("Identifier already exists: " + name);
    }

    @Override
    public T visitConsts(ConstsContext ctx) {
        for (Const_Context const_ctx : ctx.const_()) {
            String name = const_ctx.ID().getText();
            validateFree(name);
            literalVisitor.persistLiteral(const_ctx.literal(), name);
        }
        return null;
    }

    /**
     * Should return an AbstractFactory
     *
     * @param ctx
     * @return
     */
    @Override
    public T visitTypes(TypesContext ctx) {
        for (AliasContext alias : ctx.alias()) {
            String name = alias.ID().getText();
            validateFree(name);
            AbstractFactory factory = typeVisitor.visitType(alias.type());
            table.putConst(name, factory);
        }
        return null;
    }

    @Override
    public T visitVars(VarsContext ctx) {
        for (VarContext var : ctx.var()) {
            AbstractFactory factory = typeVisitor.visitType(var.type());

            for (TerminalNode id : var.id_list().ID())
                table.put(id.getText(), factory.build());
        }
        return null;
    }

    private void imprimir(Vector<Parameter> vec) {
        int n = table.topContextKeys().size();
        for (Parameter param : vec) {
            Assignable assignable = param.assig;
            if (assignable instanceof Primitive) {
                System.out.println(((Primitive) assignable).get());
            } else {
                System.out.print(assignable); // Tensor or Record
            }
        }
    }

    @Override
    public T visitSubroutine_call(Subroutine_callContext ctx) {
        table.push();
        Vector<Parameter> parameters;
        if (ctx.parameters() != null) {
            parameters = parametersVisitor.visitParameters(ctx.parameters());
        } else {
            parameters = new Vector<>();
        }

        String name;
        if (ctx.PREDEF_FUNC() != null) {
            if (ctx.parameters() != null)
                this.visit(ctx.parameters());

            name = ctx.PREDEF_FUNC().getText();
            switch (name) {
                case "imprimir": {
                    imprimir(parameters);
                    table.pop();
                    return null;
                }
            }
        }
        name = ctx.ID().getText();
        if (!table.has(name))
            throw new UnsupportedOperationException("Subroutine doesn't exists: " + name);

        Const cnst = (Const) table.get(name);
        Object obj = cnst.get();
        if (!(obj instanceof MyVisitor.Subroutine))
            throw new UnsupportedOperationException("Not a subroutine: " + name);

        MyVisitor.Subroutine sub = (MyVisitor.Subroutine) obj;
        Vector<FormalParameter> formalParameters = sub.getFormalParameters();

        if (formalParameters.size() != parameters.size())
            throw new RuntimeException("Got wrong number of parameters");
        int n = parameters.size();

        for (int i = 0; i < n; ++i) {
            FormalParameter formal = formalParameters.get(i);
            Parameter parameter = parameters.get(i);
            Assignable assig = formal.factory.build();

            if (formal.isRef) {
                if (parameter.id != null && assig.isAssignable(parameter.assig)) {
                    table.putRef(formal.name, parameter.id);
                    continue;
                }
                throw new RuntimeException("Expected Referenced variable");
            }
            if (assig.isAssignable(parameter.assig)) {
                table.put(formal.name, parameter.assig);
            }
            throw new RuntimeException("Couldn't assign parameter to formal parameter");
        }
        T ret = visitSubroutine(sub.ctx);
        table.pop();
        return ret;
    }

    @Override
    public T visitSubroutine(SubroutineContext ctx) {
        if (ctx.procedure() != null) {
            if (ctx.procedure().declarations() != null)
                this.visitDeclarations(ctx.procedure().declarations());

            if (ctx.procedure().sentences() != null)
                this.visitSentences(ctx.procedure().sentences());

            return null;
        } else {
            FunctionContext function = ctx.function();

            if (ctx.function().declarations() != null)
                this.visitDeclarations(ctx.procedure().declarations());

            if (ctx.function().sentences() != null)
                this.visitSentences(ctx.procedure().sentences());

            RetContext retctx = function.ret();

            Assignable ret = expressionVisitor.visitExpression(retctx.expression());

            AbstractFactory type = (AbstractFactory) this.visit(function.type()); // Should return factory

            if (!type.build().isAssignable(ret))
                throw new ClassCastException("Incompatible types");

            return (T) ret;
        }
    }

    @Override
    public T visitSentence(SentenceContext ctx) {
        if (ctx.subroutine_call() != null) {
            this.visit(ctx.subroutine_call());
        }

        if (ctx.expression() != null) {
            expressionVisitor.visitExpression(ctx.expression());
        }

        if (ctx.loop() != null) {

        }

        if (ctx.assign() != null) {

        }

        if (ctx.conditional_sentence() != null) {

        }

        if (ctx.subroutine_call() != null) {

        }

        return null;
    }

    @Override
    public T visitSentences(SentencesContext ctx) {
        for (SentenceContext sentence : ctx.sentence()) {
            this.visit(sentence);
        }
        return null;
    }

    class Subroutine {
        private final SubroutineContext ctx;
        private final Vector<FormalParameter> formalParameters;

        public Subroutine(SubroutineContext ctx) {
            this.ctx = ctx;
            this.formalParameters = new Vector<>();
            if (ctx.formal_parameters() != null) {
                for (Formal_parameterContext formal : ctx.formal_parameters().formal_parameter()) {
                    AbstractFactory factory = typeVisitor.visitType(formal.type());
                    for (Formal_parameter_idContext formal_id : formal.formal_parameter_id()) {
                        boolean isRef = formal_id.REF() != null;
                        String name = formal_id.ID().getText();
                        formalParameters.add(new FormalParameter(factory, name, isRef));
                    }
                }
            }
        }

        public SubroutineContext get() {
            return ctx;
        }

        public Vector<FormalParameter> getFormalParameters() {
            return formalParameters;
        }
    }

    private class LiteralVisitor extends SLGrammarParserBaseVisitor<Primitive> {
        @Override
        public Primitive visitLiteral(LiteralContext ctx) {
            if (ctx.string_literal() != null) {
                return new Cadena(ctx.string_literal().getText());
            } else if (ctx.NUMBER_LITERAL() != null) {
                return new Numeric(ctx.NUMBER_LITERAL().getText());
            } else if (ctx.PREDEF_BOOL() != null) {
                return new Logic(ctx.PREDEF_BOOL().getText());
            }
            return null;
        }

        public void persistLiteral(LiteralContext ctx, String name) {
            if (ctx.string_literal() != null) {
                Cadena cdn = new Cadena(ctx.string_literal().getText());
                table.putConst(name, cdn);
            } else if (ctx.NUMBER_LITERAL() != null) {
                Numeric num = new Numeric(ctx.NUMBER_LITERAL().getText());
                table.putConst(name, num);
            } else if (ctx.PREDEF_BOOL() != null) {
                Logic log = new Logic(ctx.PREDEF_BOOL().getText());
                table.putConst(name, log);
            }
        }
    }

    private class DataTypeVisitor extends SLGrammarParserBaseVisitor<Class> {
        @Override
        public Class visitData_type(Data_typeContext ctx) {
            String name = ctx.DATA_TYPE().getText();
            switch (name) {
                case "numerico":
                    return Numeric.class;
                case "logico":
                    return Logic.class;
                case "cadena":
                    return Cadena.class;
                default:
                    throw new RuntimeException("Class not found");
            }
        }
    }

    private class TypeVisitor extends SLGrammarParserBaseVisitor<AbstractFactory> {
        @Override
        public AbstractFactory visitRecord(RecordContext ctx) {
            Vector<String> order = new Vector<>();
            HashMap<String, Object> fMap = new HashMap<>();
            for (VarContext vctx : ctx.var()) {
                AbstractFactory factory = typeVisitor.visitType(vctx.type());
                for (TerminalNode id : vctx.id_list().ID()) {
                    String name = id.getText();
                    order.add(name);
                    fMap.put(name, factory);
                }
            }

            return new RecordFactory(fMap, order);
        }

        @Override
        public AbstractFactory visitTensor(TensorContext ctx) {
            AbstractFactory factory;
            Class clss;
            if (ctx.data_type() != null) {
                clss = dataTypeVisitor.visitData_type(ctx.data_type());
                factory = new DefaultFactory(clss);
            } else {
                factory = visitRecord(ctx.record());
                clss = Record.class;
            }

            if (ctx.vector() != null) {
                VectorContext vctx = ctx.vector();
                if (vctx.TIMES() != null) {
                    return new TensorFactory(new int[]{0}, factory, clss);
                } else {
                    Numeric num = (Numeric) expressionVisitor.visitExpression(vctx.expression());
                    return new TensorFactory(new int[]{num.asInt()}, factory, clss);
                }
            } else {
                MatrixContext mctx = ctx.matrix();
                int n = mctx.mat_dim().expression().size();
                int pos[] = new int[n];
                for (int i = 0; i < n; ++i) {
                    Numeric num = (Numeric) expressionVisitor.visitExpression(mctx.mat_dim().expression(i));
                    pos[i] = num.asInt();
                }

                return new TensorFactory(pos, factory, clss);
            }
        }

        @Override
        public AbstractFactory visitType(TypeContext ctx) {
            if (ctx.ID() != null) {
                String name = ctx.ID().getText();
                if (!table.has(name))
                    throw new RuntimeException("Type doesn't exist");
                Const obj = (Const) table.get(name);
                return (AbstractFactory) obj.get();
            } else if (ctx.data_type() != null) {
                return new DefaultFactory(dataTypeVisitor.visitData_type(ctx.data_type()));
            } else if (ctx.tensor() != null) {
                return visitTensor(ctx.tensor());
            } else {
                return visitRecord(ctx.record());
            }
        }
    }

    private class ParametersVisitor extends SLGrammarParserBaseVisitor<Vector<Parameter>> {
        @Override
        public Vector<Parameter> visitParameters(ParametersContext ctx) {
            Vector<Parameter> vec = new Vector<>();
            List<ExpressionContext> expression = ctx.expression();

            if (expression != null) {
                int n = expression.size();
                for (ExpressionContext exp : expression) {
                    Assignable assig = expressionVisitor.visitExpression(exp);

                    //if (assig != null) {
                    //  vec.add(new Parameter(assig, exp.ID().getText()));
                    //} else {
                    vec.add(new Parameter(assig));
                    //}
                }
            }
            return vec;
        }
    }

    private class ExpressionVisitor extends SLGrammarParserBaseVisitor<Assignable> {
        public String ID() {
            return null;
        }

        public Assignable visitExpression(ExpressionContext expr) {
            if (expr.children.size() == 3) {

            }

            Assignable assignable = this.visit(expr);

            return assignable;
        }

        @Override
        public Assignable visitExpressionAddition(ExpressionAdditionContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(2));
            boolean addition = ctx.children.get(1).getChild(0).getText().equals("+");

            if ((op1 instanceof Cadena || op2 instanceof Cadena) && addition) {
                return new Cadena(op1.toString() + op2.toString());
            } else if (op1 instanceof Numeric && op2 instanceof Numeric) {
                return new Numeric(((Numeric) op1).get() + (addition ? ((Numeric) op2).get() : -((Numeric) op2).get()));
            }

            throw new RuntimeException("This types are not operable");
        }

        @Override
        public Assignable visitExpressionAnd(ExpressionAndContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(2));

            if (op1 instanceof Logic && op2 instanceof Logic) {
                return new Logic(((Logic) op1).get() && ((Logic) op2).get());
            }

            throw new RuntimeException("This types are not operable");
        }

        @Override
        public Assignable visitExpressionChangeSign(ExpressionChangeSignContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(1));

            if (op2 instanceof Numeric) {
                return new Numeric(-((Numeric) op2).get());
            }

            throw new RuntimeException("This types are not operable");
        }

        @Override
        public Assignable visitExpressionMultiplication(ExpressionMultiplicationContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(2));
            boolean times = ctx.children.get(1).getChild(0).getText().equals("*");

            if (op1 instanceof Numeric && op2 instanceof Numeric) {
                return new Numeric(((Numeric) op1).get() * (times ? ((Numeric) op2).get() : (1.0 / ((Numeric) op2).get())));
            }

            throw new RuntimeException("This types are not operable");
        }

        @Override
        public Assignable visitExpressionNot(ExpressionNotContext ctx) {
            Assignable op2 = this.visit(ctx.children.get(1));

            if (op2 instanceof Logic) {
                return new Logic(!((Logic) op2).get());
            }

            throw new RuntimeException("This types are not operable");
        }

        @Override
        public Assignable visitExpressionOr(ExpressionOrContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(2));

            if (op1 instanceof Logic && op2 instanceof Logic) {
                return new Logic(((Logic) op1).get() || ((Logic) op2).get());
            }

            throw new RuntimeException("This types are not operable");
        }

        @Override
        public Assignable visitExpressionPar(ExpressionParContext ctx) {
            return this.visit(ctx.expression());
        }

        @Override
        public Assignable visitExpressionPower(ExpressionPowerContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(2));

            if (op1 instanceof Numeric && op2 instanceof Numeric) {
                return new Numeric(Math.pow(((Numeric) op1).get(), ((Numeric) op2).get()));
            }

            throw new RuntimeException("This types are not operable");
        }

        @Override
        public Assignable visitExpressionRelational(ExpressionRelationalContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(2));


            return this.visit(ctx);
        }

        @Override
        public Assignable visitExpressionVariable(ExpressionVariableContext ctx) {
            if (ctx.literal() != null)
                return literalVisitor.visitLiteral(ctx.literal());

            if (ctx.ID() != null)
                return table.get(ctx.ID().getText());

            if (ctx.access_variable() != null)
                return accessVariableVisitor.visitAccess_variable(ctx.access_variable());

            throw new RuntimeException("Expresion error");
        }
    }

    private class Access_recordVisitor extends SLGrammarParserBaseVisitor<Vector<Access>> {
        @Override
        public Vector<Access> visitAccess_record(Access_recordContext ctx) {
            Vector<Access> vec = new Vector<>();
            for (TerminalNode id : ctx.ID())
                vec.add(new RecordAccess(id.getText()));
            if (ctx.access_tensor() != null) {
                vec.addAll(accessTensorVisitor.visitAccess_tensor(ctx.access_tensor()));
            }
            return vec;
        }
    }

    private class Access_tensorVisitor extends SLGrammarParserBaseVisitor<Vector<Access>> {
        @Override
        public Vector<Access> visitAccess_tensor(Access_tensorContext ctx) {
            Vector<Access> vec = new Vector<>();
            int n = ctx.expression().size();
            int[] pos = new int[n];
            for (int i = 0; i < n; ++i) {
                Numeric aNumeric = (Numeric) expressionVisitor.visitExpression(ctx.expression(i));
                pos[i] = aNumeric.asInt();
            }
            vec.add(new TensorAccess(pos));

            if (ctx.access_record() != null) {
                vec.addAll(accessRecordVisitor.visitAccess_record(ctx.access_record()));
            }

            return vec;
        }
    }

    private class Access_variableVisitor extends SLGrammarParserBaseVisitor<Assignable> {
        @Override
        public Assignable visitAccess_variable(Access_variableContext ctx) {
            String name = ctx.ID().getText();
            validateExists(name);

            Vector<Access> vec;
            if (ctx.access_record() != null) {
                vec = accessRecordVisitor.visitAccess_record(ctx.access_record());
            } else {
                vec = accessTensorVisitor.visitAccess_tensor(ctx.access_tensor());
            }

            Assignable accesed_var = table.get(name);

            if (accesed_var instanceof Cadena) {
                if (vec.size() == 1 && vec.get(0) instanceof TensorAccess) {
                    TensorAccess ta = (TensorAccess) vec.get(0);
                    if (ta.pos.length == 1) {
                        return ((Cadena) accesed_var).charAt(ta.pos[0]);
                    }
                }
                throw new RuntimeException();
            }

            for (Access ac : vec) {
                if (ac instanceof TensorAccess) {
                    TensorAccess ta = (TensorAccess) ac;
                    Tensor t = (Tensor) accesed_var;
                    accesed_var = t.get(ta.pos);
                } else {
                    RecordAccess ra = (RecordAccess) ac;
                    Record r = (Record) accesed_var;
                    accesed_var = r.get(ra.name);
                }
            }

            return accesed_var;
        }
    }
}
