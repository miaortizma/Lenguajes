package interpreter;

import gen.SLGrammarParser.*;
import gen.SLGrammarParserBaseVisitor;
import interpreter.assignables.Assignable;
import interpreter.factories.AbstractFactory;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.swing.*;


class Subroutine implements Assignable {

    private final SubroutineContext ctx;

    public Subroutine(SubroutineContext ctx) { this.ctx = ctx; }

    @Override
    public boolean IsAssignable(Object obj) { return false; }

    @Override
    public void AssignIfPossible(Object obj) { throw new UnsupportedOperationException();}

    public SubroutineContext get() { return ctx; }

}


public class MyVisitor<T> extends SLGrammarParserBaseVisitor<T> {

    StackedContextMap table = new StackedContextMap();

    @Override
    public T visitProgram(ProgramContext ctx) {

        //añadir declaraciones globales (CONSTS, VARIABLES, TIPOS)

        this.visit(ctx.declarations());

        SubroutinesContext subs = ctx.subroutines();
        for(SubroutineContext subroutine : subs.subroutine()) {
            String str = subroutine.ID().getText();
            table.putConst(str, new Subroutine(subroutine));
            System.out.println(str);
        }
        //añadir funciones a el ámbito de variables

        this.visit(ctx.sentences());

        return null;
    }

    @Override
    //
    public T visitConsts(ConstsContext ctx) {
        return null;
    }


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


    @Override
    public T visitSubroutine(SubroutineContext ctx) {
        table.push();
        this.visit(ctx.formal_parameters());
        if(ctx.procedure() != null) {
            this.visit(ctx.procedure().declarations());
            this.visit(ctx.procedure().sentences());

            table.pop();
            return null;
        } else {
            FunctionContext function = ctx.function();

            this.visit(function.declarations());
            this.visit(function.sentences());

            RetContext retctx = function.ret();

            Assignable ret = (Assignable) this.visit(retctx.expression()); // Should return Assignable

            AbstractFactory type = (AbstractFactory) this.visit(function.type()); // Should return factory

            if(!type.build().IsAssignable(ret))
                throw new ClassCastException("Incompatible types");

            return ret;
        }
    }

    @Override
    public T visitFormal_parameters(Formal_parametersContext ctx) {
        return null;
    }

    @Override
    public T visitSentence(SentenceContext ctx) {
        return null;
    }


    @Override
    public T visitSubroutine_call(Subroutine_callContext ctx) {
        Subroutine_call_nameContext nameCtx = ctx.subroutine_call_name();
        String name;
        if(nameCtx.PREDEF_FUNC() != null) {
            name = nameCtx.PREDEF_FUNC().getText();
            switch(name) {
                case "imprimir": {

                    System.out.println();
                    break;
                }
            }
        }
        name = nameCtx.ID().getText();

        if(!table.has(name))
            throw new UnsupportedOperationException("Subroutine doesn't exists");

        Assignable assg = table.get(name);

        if(!(assg instanceof Subroutine))
            throw new UnsupportedOperationException("Not a function: " + assg.getClass());

        Subroutine sub = (Subroutine) assg;

        return this.visit(sub.get());
    }
}
