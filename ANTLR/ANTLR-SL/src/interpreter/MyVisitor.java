package interpreter;

import gen.SLGrammarParser.*;
import gen.SLGrammarParserBaseVisitor;
import interpreter.assignables.*;
import interpreter.factories.AbstractFactory;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Vector;


class Subroutine implements Assignable {

    private final SubroutineContext ctx;

    public Subroutine(SubroutineContext ctx) { this.ctx = ctx; }

    @Override
    public boolean IsAssignable(Object obj) { return false; }

    @Override
    public void AssignIfPossible(Object obj) { throw new UnsupportedOperationException();}

    public SubroutineContext get() { return ctx; }

}

class Access { }

class TensorAccess extends Access {
    int [] pos;

    public TensorAccess(int [] pos) { this.pos = pos; }

}


class RecordAccess extends Access {
    String name;

    public RecordAccess(String name) { this.name = name; }

}

// mirar ejemplo https://jakubdziworski.github.io/java/2016/04/01/antlr_visitor_vs_listener.html


public class MyVisitor<T> extends SLGrammarParserBaseVisitor<T> {

    StackedContextMap table = new StackedContextMap();
    ExpressionVisitor expvis = new ExpressionVisitor();

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
                Access_tensorVisitor visitor = new Access_tensorVisitor();
                vec.addAll(visitor.visitAccess_tensor(ctx.access_tensor()));
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
                if((int) aNumeric.get() != aNumeric.get())
                    throw new RuntimeException("Expression is not integer");
                pos[i] = (int) aNumeric.get();
            }
            vec.add(new TensorAccess(pos));

            if(ctx.access_record() != null){
                Access_recordVisitor acvis = new Access_recordVisitor();
                vec.addAll(acvis.visitAccess_record(ctx.access_record()));
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
                Access_recordVisitor acvis = new Access_recordVisitor();
                vec = acvis.visitAccess_record(ctx.access_record());
            }else {
                Access_tensorVisitor atvis = new Access_tensorVisitor();
                vec = atvis.visitAccess_tensor(ctx.access_tensor());
            }

            Assignable accesed_var = table.get(name);

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
        for(TypeContext tipo : ctx.type()){
            System.out.print(tipo.ID());
        }
        return null;
    }

    @Override
    public T visitVars(VarsContext ctx) {
        return null;
    }


    private void imprimir() {
        if (table.topContextKeys().size() != 1)
            throw new RuntimeException("Expected one argument but got none");
        Assignable assignable = table.get("1");
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

    @Override
    public T visitParameters(ParametersContext ctx) {
        int n = ctx.expression().size();
        for(int i = 1; i <= n; ++i)
            table.put(""+i, expvis.visitExpression(ctx.expression(i - 1)));
        return null;
    }

    @Override
    public T visitSubroutine_call(Subroutine_callContext ctx) {
        table.push();
        if(ctx.parameters() != null)
            this.visit(ctx.parameters());

        String name;
        if(ctx.PREDEF_FUNC() != null) {
            name = ctx.PREDEF_FUNC().getText();
            switch(name) {
                case "imprimir": {
                    imprimir();
                    table.pop();
                    return null;
                }
            }
        }
        name = ctx.ID().getText();
        if(!table.has(name))
            throw new UnsupportedOperationException("Subroutine doesn't exists");

        Assignable assg = table.get(name);

        if(!(assg instanceof Subroutine))
            throw new UnsupportedOperationException("Not a function: " + assg.getClass());

        Subroutine sub = (Subroutine) assg;
        T ret = this.visitSubroutine(sub.get());
        table.pop();
        return ret;
    }

    @Override
    public T visitSubroutine(SubroutineContext ctx) {
        if(ctx.formal_parameters() != null)
            this.visit(ctx.formal_parameters()); // check that sub parameters and formal parameters coincide

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
    public T visitFormal_parameters(Formal_parametersContext ctx) {
        for()
        return null;
    }

    @Override
    public T visitSentence(SentenceContext ctx) {
        if(ctx.subroutine_call() != null) {
            this.visit(ctx.subroutine_call());
        }
        return null;
    }

}
