package interpreter;

import gen.SLGrammarParser.*;
import gen.SLGrammarParserBaseVisitor;
import interpreter.assignables.Comparable;
import interpreter.assignables.*;
import interpreter.factories.AbstractFactory;
import interpreter.factories.DefaultFactory;
import interpreter.factories.RecordFactory;
import interpreter.factories.TensorFactory;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

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
    ProgramVisitor programVisitor = new ProgramVisitor();
    EvalVisitor evalVisitor = new EvalVisitor();

    @Override
    public T visitProgram(ProgramContext ctx) {
        return (T) programVisitor.visitProgram(ctx);
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


    private Assignable imprimir(Vector<Parameter> vec) {
        for (Parameter param : vec) {
            Assignable assignable = param.assig;
            if (assignable instanceof Primitive) {
                System.out.println(((Primitive) assignable).get());
            } else {
                System.out.print(assignable); // Tensor or Record
            }
        }
        return null;
    }

    private Class deriveClassFromFactory(AbstractFactory factory) {
        if (factory instanceof RecordFactory)
            return Record.class;
        if (factory instanceof TensorFactory)
            return Tensor.class;
        if (factory instanceof DefaultFactory) {
            DefaultFactory defaultFactory = (DefaultFactory) factory;
            return defaultFactory.getClss();
        }
        throw new RuntimeException("deriveClassFromFactoryError");
    }

    private Assignable leer(Vector<Parameter> parameters) {
        for (Parameter param : parameters) {
            Scanner sc = new Scanner(System.in);
            if(param.id == null)
                throw new RuntimeException("Expected identifier got expression");
            Assignable assig = table.get(param.id);
            String input = sc.next();
            if (assig instanceof Numeric)
                assig.assignIfPossible(new Numeric(input));

            if (assig instanceof Logic)
                assig.assignIfPossible(new Logic(input));


            if (assig instanceof Cadena)
                assig.assignIfPossible(new Cadena(input));


            DefaultFactory factory = new DefaultFactory(param.assig.getClass());

            //table.put(param.id, new );
        }
        return null;
    }

    private Assignable sin(Vector<Parameter> parameters) {
        if(parameters.size() != 1)
            throw new RuntimeException("Sin function expects 1 parameter");
        Assignable assignable = parameters.firstElement().assig;
        if (!(assignable instanceof Numeric))
            throw new RuntimeException("Expected Numeric parameter");
        Numeric num = (Numeric) assignable;

        return new Numeric(Math.sin(num.get()));
    }

    private void validateExists(String name) {
        if (!table.has(name))
            throw new RuntimeException("Identifier doesn't exists: " + name);
    }

    private void validateFree(String name) {
        if (table.has(name))
            throw new RuntimeException("Identifier already exists: " + name);
    }

    private class ProgramVisitor<T> extends SLGrammarParserBaseVisitor<T> {


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

        @Override
        public T visitFrom_loop(From_loopContext ctx) {
            visitAssign(ctx.assign());
            Assignable assStart = table.get(ctx.assign().ID().getText());
            if (assStart instanceof Numeric) {
                Numeric start = (Numeric) assStart;
                Assignable end = expressionVisitor.visitExpression(ctx.expression(0));
                if (end instanceof Numeric) {
                    int step = 1;
                    ExpressionContext contextStep = ctx.expression(1);
                    if (contextStep != null) {
                        Assignable assignStep = expressionVisitor.visitExpression(contextStep);

                        if (assignStep instanceof Numeric) {
                            step = ((Numeric) assignStep).asInt();
                        } else {
                            throw new RuntimeException("Invalid type in step");
                        }
                    }

                    int times = (((Numeric) end).asInt() - ((Numeric) start).asInt()) / step;

                    for (int i = 0; i <= times; i++) {
                        for (SentencesContext sentences : ctx.sentences()) {
                            visitSentences(sentences);
                            start = (Numeric) table.get(ctx.assign().ID().getText());
                            if (start.equals(end)) {
                                break;
                            }
                        }
                        table.put(ctx.assign().ID().getText(), new Numeric(start.asInt() + step));
                    }
                    return null;
                }
            }
            throw new RuntimeException("Sentence to evaluate in FROM structure must be Logic");

        }

        @Override
        public T visitRepeat_loop(Repeat_loopContext ctx) {
            Assignable assignable = expressionVisitor.visitExpression(ctx.expression());
            if (assignable instanceof Logic) {
                do {
                    assignable = expressionVisitor.visitExpression(ctx.expression());
                    visitListSentences(ctx.sentences());
                } while (((Logic) assignable).get());
                return null;
            }

            throw new RuntimeException("Sentence to evaluate in REPEAT structure must be Logic");
        }

        @Override
        public T visitWhile_loop(While_loopContext ctx) {
            Assignable assignable = expressionVisitor.visitExpression(ctx.expression());
            if (assignable instanceof Logic) {
                while (((Logic) assignable).get()) {
                    visitListSentences(ctx.sentences());
                    assignable = expressionVisitor.visitExpression(ctx.expression());
                }
            } else {
                throw new RuntimeException("Sentence to evaluate in WHILE structure must be Logic");
            }
            return null;
        }

        @Override
        public T visitSentence(SentenceContext ctx) {

            if (ctx.expression() != null) {
                expressionVisitor.visitExpression(ctx.expression());
            }

            if (ctx.loop() != null) {
                visit(ctx.loop());
            }

            EvalContext evalContext = ctx.eval();
            if (evalContext != null) {
                evalVisitor.visitEval(evalContext);
            }

            AssignContext assignContext = ctx.assign();
            if (assignContext != null) {
                visitAssign(assignContext);
            }

            Conditional_sentenceContext conditionalSentenceContext = ctx.conditional_sentence();
            if (conditionalSentenceContext != null) {
                visitConditional_sentence(conditionalSentenceContext);
            }

            return null;
        }

        @Override
        public T visitConditional_sentence(Conditional_sentenceContext ctx) {
            Assignable toEvaluate = expressionVisitor.visitExpression(ctx.expression());
            //System.out.println("Conditional Sentence");
            if (toEvaluate instanceof Logic) {
                if (((Logic) toEvaluate).get()) {
                    visitListSentences(ctx.sentences());
                } else {
                    List<Conditional_sentence_else_ifContext> elsifs = ctx.conditional_sentence_else_if();
                    if (elsifs != null)
                        for (Conditional_sentence_else_ifContext elsif : elsifs){
                            Logic logic = (Logic) expressionVisitor.visitExpression(elsif.expression());
                            if (logic.get()){
                                visitListSentences(elsif.sentences());
                                return null;
                            }
                        }

                    Conditional_sentence_final_elseContext finalElse = ctx.conditional_sentence_final_else();
                    if (finalElse != null)
                        visitListSentences(finalElse.sentences());
                }
            } else {
                throw new RuntimeException("Sentence to evaluate in IF structure must be Logic");
            }
            return null;
        }

        @Override
        public T visitAssign(AssignContext assignContext) {
            ExpressionContext expressionContext = assignContext.expression();
            if (expressionContext != null) {
                Assignable assignable = expressionVisitor.visitExpression(expressionContext);

                if (assignContext.ID() != null && assignable != null) {
                    table.put(assignContext.ID().getText(), assignable);
                } else if (assignContext.access_variable() != null) {
                    Access_variableContext accessVariableContext = assignContext.access_variable();
                    String name = accessVariableContext.ID().getText();
                    Assignable assgn = accessVariableVisitor.visitAccess_variable(accessVariableContext);
                    assgn.assignIfPossible(assignable);
                }
            } else if (assignContext.structured_literal() != null) {
                // Assignable assignable = expressionVisitor.visitExpression();
            /*if (assignContext.ID() != null && assignable != null) {
                table.put(assignContext.ID().getText(), assignable);
            } else if (assignContext.access_variable() != null) {
                // accessVariableVisitor.visitAccess_variable();
            }*/
            }
            return null;
        }

        public void visitListSentences(List<SentencesContext> sentences) {
            for (SentencesContext sentence : sentences) {
                this.visitSentences(sentence);
            }
        }

        @Override
        public T visitSentences(SentencesContext ctx) {
            for (SentenceContext sentence : ctx.sentence())
                visitSentence(sentence);

            return null;
        }

    }

    private class EvalVisitor extends SLGrammarParserBaseVisitor<Boolean> {
        @Override
        public Boolean visitEval(EvalContext ctx) {
            boolean evaluated = false;

            Iterator<Eval_caseContext> casesIterator = ctx.eval_case().iterator();
            while (casesIterator.hasNext() && !evaluated) {
                evaluated = this.visitEval_case(casesIterator.next());
            }

            // else
            if (!evaluated) {
                programVisitor.visitListSentences(ctx.sentences());
            }

            return true;
        }

        @Override
        public Boolean visitEval_case(Eval_caseContext ctx) {
            ExpressionContext expressionContext = ctx.expression();
            if (expressionContext != null) {
                Assignable assignable = expressionVisitor.visitExpression(expressionContext);
                if (assignable instanceof Logic) {
                    if (((Logic) assignable).get()) {
                        programVisitor.visitListSentences(ctx.sentences());
                        return true;
                    }
                    return false;
                }
            }

            throw new RuntimeException("The expression to be evaluated is invalid");
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
            } else if (ctx.record() != null){
                factory = visitRecord(ctx.record());
                clss = Record.class;
            } else {
                String name = ctx.ID().getText();
                Const obj = (Const) table.get(name);
                factory = (AbstractFactory) obj.get();
                clss = deriveClassFromFactory(factory);
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
                for (ExpressionContext exp : expression) {

                    Assignable assig = expressionVisitor.visitExpression(exp);

                    if (exp instanceof ExpressionVariableContext) {
                        ExpressionVariableContext expCtx = (ExpressionVariableContext) exp;
                        if (expCtx.ID() != null) {
                            vec.add(new Parameter(assig, expCtx.ID().getText()));
                            continue;
                        }
                    }

                    vec.add(new Parameter(assig));
                }
            }
            return vec;
        }
    }

    private class ExpressionVisitor extends SLGrammarParserBaseVisitor<Assignable> {

        public Assignable visitExpression(ExpressionContext expr) {
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

            throw new RuntimeException("These types are not operable");
        }

        @Override
        public Assignable visitExpressionAnd(ExpressionAndContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(2));

            if (op1 instanceof Logic && op2 instanceof Logic) {
                return new Logic(((Logic) op1).get() && ((Logic) op2).get());
            }

            throw new RuntimeException("These types are not operable");
        }

        @Override
        public Assignable visitExpressionChangeSign(ExpressionChangeSignContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(1));

            if (op2 instanceof Numeric) {
                return new Numeric(-((Numeric) op2).get());
            }

            throw new RuntimeException("These types are not operable");
        }

        @Override
        public Assignable visitExpressionMultiplication(ExpressionMultiplicationContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(2));

            if (!(op1 instanceof Numeric) || !(op2 instanceof Numeric)) {
                throw new RuntimeException("These types are not operable");
            }

            switch (ctx.children.get(1).getChild(0).getText()) {
                case "*":
                    return new Numeric(((Numeric) op1).get() * ((Numeric) op2).get());
                case "%":
                    return new Numeric(((Numeric) op1).get() % ((Numeric) op2).get());
                case "/":
                    return new Numeric(((Numeric) op1).get() / ((Numeric) op2).get());
            }

            throw new RuntimeException("Error in operation");
        }

        @Override
        public Assignable visitExpressionNot(ExpressionNotContext ctx) {
            Assignable op2 = this.visit(ctx.children.get(1));

            if (op2 instanceof Logic) {
                return new Logic(!((Logic) op2).get());
            }

            throw new RuntimeException("These types are not operable");
        }

        @Override
        public Assignable visitExpressionOr(ExpressionOrContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(2));

            if (op1 instanceof Logic && op2 instanceof Logic) {
                return new Logic(((Logic) op1).get() || ((Logic) op2).get());
            }

            throw new RuntimeException("These types are not operable");
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

            throw new RuntimeException("These types are not operable");
        }

        @Override
        public Assignable visitExpressionRelational(ExpressionRelationalContext ctx) {
            Assignable op1 = this.visit(ctx.children.get(0));
            Assignable op2 = this.visit(ctx.children.get(2));
            String operator = ctx.children.get(1).getChild(0).getText();

            if (op1 instanceof Comparable && op2 instanceof Comparable) {
                Comparable cp1 = (Comparable) op1;
                Comparable cp2 = (Comparable) op2;
                switch (operator) {
                    case ">":
                        return new Logic(cp1.greaterThan(cp2));
                    case "<":
                        return new Logic(cp1.lessThan(cp2));
                    case ">=":
                        return new Logic(cp1.greaterOrEqualThan(cp2));
                    case "==":
                        return new Logic(cp1.equals(cp2));
                    case "<>":
                        return new Logic(!cp1.equals(cp2));
                    case "<=":
                        return new Logic(cp1.lessOrEqualThan(cp2));
                }
            } else {
                throw new RuntimeException("These types are not operable");
            }
            return null;
        }

        @Override
        public Assignable visitExpressionVariable(ExpressionVariableContext ctx) {

            if (ctx.literal() != null)
                return literalVisitor.visitLiteral(ctx.literal());

            if (ctx.ID() != null)
                return table.get(ctx.ID().getText());

            if (ctx.access_variable() != null)
                return accessVariableVisitor.visitAccess_variable(ctx.access_variable());

            if (ctx.subroutine_call() != null)
                return visitSubroutine_call(ctx.subroutine_call());

            throw new RuntimeException("VisitExpressionVariable error");
        }

        public Assignable visitPredefFunc(String name, Vector<Parameter> parameters) {
            switch(name) {
                case "imprimir":
                    return imprimir(parameters);
                case "leer":
                    return leer(parameters);
                case "sin":
                    return sin(parameters);
            }
            return null;
        }

        @Override
        public Assignable visitSubroutine_call(Subroutine_callContext ctx) {
            Vector<Parameter> parameters;
            if (ctx.parameters() != null) {
                parameters = parametersVisitor.visitParameters(ctx.parameters());
            } else {
                parameters = new Vector<>();
            }

            table.push();

            String name;
            if (ctx.predef_func() != null) {
                name = ctx.predef_func().getText();
                Assignable ret = visitPredefFunc(name, parameters);
                table.pop();
                return ret;
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
                    continue;
                }
                throw new RuntimeException("Couldn't assign parameter to formal parameter");
            }

            Assignable ret = visitSubroutine(sub.ctx);
            table.pop();
            return ret;
        }

        @Override
        public Assignable visitSubroutine(SubroutineContext ctx) {
            if (ctx.procedure() != null) {
                if (ctx.procedure().declarations() != null)
                    programVisitor.visitDeclarations(ctx.procedure().declarations());

                if (ctx.procedure().sentences() != null)
                    programVisitor.visitSentences(ctx.procedure().sentences());

                return null;
            } else {
                FunctionContext function = ctx.function();

                if (function.declarations() != null)
                    programVisitor.visitDeclarations(function.declarations());

                if (function.sentences() != null)
                    programVisitor.visitSentences(function.sentences());

                RetContext retctx = function.ret();

                Assignable ret = expressionVisitor.visitExpression(retctx.expression());

                AbstractFactory type = typeVisitor.visitType(function.type()); // Should return factory

                if (!type.build().isAssignable(ret))
                    throw new ClassCastException("Incompatible types");

                return ret;
            }
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
