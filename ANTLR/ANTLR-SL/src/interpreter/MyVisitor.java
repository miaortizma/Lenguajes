package interpreter;

import gen.SLGrammarParser.*;
import gen.SLGrammarParserBaseVisitor;

/*
Numerico -> Double
Cadena -> String

 */




public class MyVisitor<T> extends SLGrammarParserBaseVisitor<T> {

    StackedContextMap table = new StackedContextMap();

    /*
    public Object getType(TiporetContext ctx) {
        //if(ctx.ID())
        return new Double(1);
    }*/

    @Override
    public T visitProgram(ProgramContext ctx) {

        //añadir declaraciones globales (CONSTS, VARIABLES, TIPOS)
        this.visit(ctx.declarations());
        this.visit(ctx.subroutines());
        //añadir funciones a el ámbito de variables

        return null;
    }

    @Override
    public T visitConsts(ConstsContext ctx) {
        return null;
    }

    /*
    @Override
    public T visitTipos(TiposContext ctx) {
        for(TipoContext tipo : ctx.tipo()){
            System.out.print(tipo.tipobasico());
        }
        return null;
    }

    @Override
    public T visitVars(VarsContext ctx) {
        return null;
    }

    @Override
    public T visitSubrutinas(SubrutinasContext ctx) {
        for(SubrutinaContext subrutina : ctx.subrutina()) {
            String str = subrutina.nombre_subrutina.getText();
            table.put(str, subrutina);
            System.out.println(str);
        }
        return null;
    }

    @Override
    public T visitSubrutina(SubrutinaContext ctx) {
        table.push();
        this.visit(ctx.parametrosformales());
        if(ctx.procedimiento() != null) {
            this.visit(ctx.procedimiento().declaraciones());
            this.visit(ctx.procedimiento().sentencias());

            table.pop();
            return null;
        } else {
            FuncionContext funcion = ctx.funcion();

            this.visit(funcion.declaraciones());
            this.visit(funcion.sentencias());

            RetContext retctx = funcion.ret();

            Object ret;
            if(retctx.expr() != null) {
                ret = this.visit(retctx.expr());
            } else {
                ret = table.get(retctx.ID().getText());
            }

            Object type = this.getType(funcion.tiporet());

            if( ret.getClass().equals(type.getClass()) ) {
                table.pop();
                return (T) (Object) ret;
            }else {
                throw new ClassCastException("Incompatible types");
            }
        }
    }

    @Override
    public T visitParametrosformales(ParametrosformalesContext ctx) {
        return null;
    }

    @Override
    public T visitSentencia(SentenciaContext ctx) {
        return null;
    }

    @Override
    public T visitLlamadosub(LlamadosubContext ctx) {
        return null;
    }

     */
}
