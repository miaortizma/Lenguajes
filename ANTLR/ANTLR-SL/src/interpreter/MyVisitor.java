package interpreter;

import gen.SLGrammarParser.*;
import gen.SLGrammarParserBaseVisitor;
import interpreter.assignables.*;
import interpreter.factories.AbstractFactory;
import interpreter.factories.DefaultFactory;
import interpreter.factories.RecordFactory;
import interpreter.factories.TensorFactory;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Vector;


class Access { }

class TensorAccess extends Access {
    int [] pos;

    public TensorAccess(int [] pos) { this.pos = pos; }

}


class RecordAccess extends Access {
    String name;

    public RecordAccess(String name) { this.name = name; }

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
    ExpressionVisitor expvis = new ExpressionVisitor();
    TypeVisitor tyvis = new TypeVisitor();
    Access_variableVisitor avvis = new Access_variableVisitor();
    Access_tensorVisitor atvis = new Access_tensorVisitor();
    Access_recordVisitor arvis = new Access_recordVisitor();
    ParametersVisitor prmvis = new ParametersVisitor();
    Data_typeVisitor dtvis = new Data_typeVisitor();


    class Subroutine {

        private final SubroutineContext ctx;
        private final Vector<FormalParameter> formalParameters;

        public Subroutine(SubroutineContext ctx) {
            this.ctx = ctx;
            this.formalParameters = new Vector<>();
            if(ctx.formal_parameters() != null) {
                for (Formal_parameterContext formal : ctx.formal_parameters().formal_parameter()) {
                    AbstractFactory factory = tyvis.visitType(formal.type());
                    for (Formal_parameter_idContext formal_id : formal.formal_parameter_id()) {
                        boolean isRef = formal_id.REF() != null;
                        String name = formal_id.ID().getText();
                        formalParameters.add(new FormalParameter(factory, name, isRef));
                    }
                }
            }
        }

        public SubroutineContext get() { return ctx; }

        public Vector<FormalParameter> getFormalParameters() { return formalParameters; }

    }

    private class Data_typeVisitor extends SLGrammarParserBaseVisitor<Class> {
        @Override
        public Class visitData_type(Data_typeContext ctx) {
            String name = ctx.DATA_TYPE().getText();
            switch(name) {
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
                AbstractFactory factory = tyvis.visitType(vctx.type());
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
                clss = dtvis.visitData_type(ctx.data_type());
                factory = new DefaultFactory(clss);
            } else {
                factory = visitRecord(ctx.record());
                clss = Record.class;
            }

            if (ctx.vector() != null) {
                VectorContext vctx = ctx.vector();
                if(vctx.TIMES() != null) {
                    return new TensorFactory(new int [] {0}, factory, clss);
                } else {
                    Numeric num = (Numeric) expvis.visitExpression(vctx.expression());
                    return new TensorFactory(new int [] {num.asInt()}, factory, clss);
                }
            } else {
                MatrixContext mctx = ctx.matrix();
                int n = mctx.mat_dim().expression().size();
                int pos[] = new int[n];
                for (int i = 0; i < n; ++i) {
                    Numeric num = (Numeric) expvis.visitExpression(mctx.mat_dim().expression(i));
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
                return new DefaultFactory(dtvis.visitData_type(ctx.data_type()));
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
            if (ctx.expression() != null) {
                int n = ctx.expression().size();
                for (ExpressionContext exp : ctx.expression()) {
                    Assignable assig = expvis.visitExpression(exp);
                    if(exp.ID() != null) {
                        vec.add(new Parameter(assig, exp.ID().getText()));
                    } else {
                        vec.add(new Parameter(assig));
                    }
                }
            }
            return vec;
        }
    }

    private class ExpressionVisitor extends SLGrammarParserBaseVisitor<Assignable> {
        @Override
        public Assignable visitExpression(ExpressionContext ctx) {
            if (ctx.access_variable() != null) {
                Access_variableVisitor vis = new Access_variableVisitor();
                return vis.visitAccess_variable(ctx.access_variable());
            } else if (ctx.ID() != null) {
                return table.get(ctx.ID().getText());
            } else if (ctx.STRING_LITERAL() != null) {
                return new Cadena(ctx.STRING_LITERAL().getText());
            } else if (ctx.NUMBER_LITERAL() != null) {
                return new Numeric(ctx.NUMBER_LITERAL().getText());
            } else if (ctx.PREDEF_BOOL() != null) {
                return new Logic(ctx.PREDEF_BOOL().getText());
            }
            return new Numeric(1);
        }
    }

    private class Access_recordVisitor extends SLGrammarParserBaseVisitor<Vector<Access>> {
        @Override
        public Vector<Access> visitAccess_record(Access_recordContext ctx) {
            Vector<Access> vec = new Vector<>();
            for(TerminalNode id : ctx.ID())
                vec.add(new RecordAccess(id.getText()));
            if(ctx.access_tensor() != null){
                vec.addAll(atvis.visitAccess_tensor(ctx.access_tensor()));
            }
            return vec;
        }
    }

    private class Access_tensorVisitor extends SLGrammarParserBaseVisitor<Vector<Access>> {
        @Override
        public Vector<Access> visitAccess_tensor(Access_tensorContext ctx) {
            Vector<Access> vec = new Vector<>();
            int n = ctx.expression().size();
            int [] pos = new int[n];
            for(int i = 0; i < n; ++i) {
                Numeric aNumeric = (Numeric) expvis.visitExpression(ctx.expression(i));
                pos[i] = aNumeric.asInt();
            }
            vec.add(new TensorAccess(pos));

            if(ctx.access_record() != null){
                vec.addAll(arvis.visitAccess_record(ctx.access_record()));
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
            if(ctx.access_record() != null) {
                vec = arvis.visitAccess_record(ctx.access_record());
            }else {
                vec = atvis.visitAccess_tensor(ctx.access_tensor());
            }

            Assignable accesed_var = table.get(name);

            if(accesed_var instanceof Cadena) {
                if(vec.size() == 1 && vec.get(0) instanceof TensorAccess) {
                    TensorAccess ta = (TensorAccess) vec.get(0);
                    if(ta.pos.length == 1) {
                        return ((Cadena) accesed_var).charAt(ta.pos[0]);
                    }
                }
                throw new RuntimeException();
            }

            for(Access ac : vec) {
                if(ac instanceof TensorAccess) {
                    TensorAccess ta = (TensorAccess) ac;
                    Tensor t = (Tensor) accesed_var;
                    accesed_var = t.get(ta.pos);
                }else {
                    RecordAccess ra = (RecordAccess) ac;
                    Record r = (Record) accesed_var;
                    accesed_var = r.get(ra.name);
                }
            }

            return accesed_var;
        }

    }


    @Override
    public T visitProgram(ProgramContext ctx) {

        //añadir declaraciones globales (CONSTS, VARIABLES, TIPOS)
        if(ctx.declarations() != null)
            this.visit(ctx.declarations());

        SubroutinesContext subs = ctx.subroutines();
        for(SubroutineContext subroutine : subs.subroutine()) {
            String str = subroutine.ID().getText();
            table.putConst(str, new Subroutine(subroutine));
        }
        //añadir funciones a el ámbito de variables
        if(ctx.sentences() != null)
            this.visitSentences(ctx.sentences());

        return null;
    }

    private void validateExists(String name) {
        if(!table.has(name))
            throw new RuntimeException("Identifier doesn't exists: "+name);
    }

    private void validateFree(String name) {
        if(table.has(name))
            throw new RuntimeException("Identifier already exists: " + name);
    }

    @Override
    public T visitConsts(ConstsContext ctx) {
        for(Const_Context const_ctx : ctx.const_()) {
            String name = const_ctx.ID().getText();
            validateFree(name);
            if(const_ctx.STRING_LITERAL() != null) {
                Cadena cdn = new Cadena(const_ctx.STRING_LITERAL().getText());
                table.putConst(name, cdn);
            } else if (const_ctx.NUMBER_LITERAL() != null) {
                Numeric num = new Numeric(const_ctx.NUMBER_LITERAL().getText());
                table.putConst(name, num);
            } else if (const_ctx.PREDEF_BOOL() != null) {
                Logic log = new Logic(const_ctx.PREDEF_BOOL().getText());
                table.putConst(name, log);
            }
        }
        return null;
    }


    /**
     * Should return an AbstractFactory
     * @param ctx
     * @return
     */
    @Override
    public T visitTypes(TypesContext ctx) {
        for (AliasContext alias : ctx.alias()) {
            String name = alias.ID().getText();
            validateFree(name);
            AbstractFactory factory = tyvis.visitType(alias.type());
            table.putConst(name, factory);
        }
        return null;
    }

    @Override
    public T visitVars(VarsContext ctx) {
        for (VarContext var : ctx.var()) {
            AbstractFactory factory = tyvis.visitType(var.type());

            for (TerminalNode id : var.id_list().ID())
                table.put(id.getText(), factory.build());
        }
        return null;
    }


    private void imprimir(Vector<Parameter> vec) {
        int n = table.topContextKeys().size();
        for (Parameter param  : vec) {
            Assignable assignable = param.assig;
            if (assignable instanceof Numeric){
                System.out.println(((Numeric) assignable).get());
            } else if (assignable instanceof Cadena) {
                System.out.println(((Cadena) assignable).get());
            } else if (assignable instanceof Logic) {
                System.out.println(((Logic) assignable).get());
            } else {
                System.out.print(assignable); // Tensor or Record
            }
        }
    }

    @Override
    public T visitSubroutine_call(Subroutine_callContext ctx) {
        table.push();
        Vector<Parameter> parameters;
        if(ctx.parameters() != null){
            parameters = prmvis.visitParameters(ctx.parameters());
        } else {
            parameters = new Vector<>();
        }

        String name;
        if(ctx.PREDEF_FUNC() != null) {
            if(ctx.parameters() != null)
                this.visit(ctx.parameters());

            name = ctx.PREDEF_FUNC().getText();
            switch(name) {
                case "imprimir": {
                    imprimir(parameters);
                    table.pop();
                    return null;
                }
            }
        }
        name = ctx.ID().getText();
        if(!table.has(name))
            throw new UnsupportedOperationException("Subroutine doesn't exists: "+name);

        Const cnst = (Const) table.get(name);
        Object obj = cnst.get();
        if(!(obj instanceof MyVisitor.Subroutine))
            throw new UnsupportedOperationException("Not a subroutine: "+name);

        MyVisitor.Subroutine sub = (MyVisitor.Subroutine) obj;
        Vector<FormalParameter> formalParameters = sub.getFormalParameters();

        if(formalParameters.size() != parameters.size())
            throw new RuntimeException("Got wrong number of parameters");
        int n = parameters.size();

        for (int i = 0; i < n; ++i) {
            FormalParameter formal = formalParameters.get(i);
            Parameter parameter = parameters.get(i);
            Assignable assig = formal.factory.build();

            if (formal.isRef) {
               if(parameter.id != null && assig.IsAssignable(parameter.assig)) {
                   table.putRef(formal.name, parameter.id);
                   continue;
               }
               throw new RuntimeException("Expected Referenced variable");
            }
            if(assig.IsAssignable(parameter.assig)) {
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

        if(ctx.procedure() != null) {

            if(ctx.procedure().declarations() != null)
                this.visitDeclarations(ctx.procedure().declarations());

            if(ctx.procedure().sentences() != null)
                this.visitSentences(ctx.procedure().sentences());

            return null;
        } else {
            FunctionContext function = ctx.function();

            if(ctx.function().declarations() != null)
                this.visitDeclarations(ctx.procedure().declarations());

            if(ctx.function().sentences() != null)
                this.visitSentences(ctx.procedure().sentences());

            RetContext retctx = function.ret();

            Assignable ret = expvis.visitExpression(retctx.expression());

            AbstractFactory type = (AbstractFactory) this.visit(function.type()); // Should return factory

            if(!type.build().IsAssignable(ret))
                throw new ClassCastException("Incompatible types");

            return (T) ret;
        }
    }


    @Override
    public T visitSentence(SentenceContext ctx) {
        if(ctx.subroutine_call() != null) {
            this.visit(ctx.subroutine_call());
        }
        return null;
    }

}
