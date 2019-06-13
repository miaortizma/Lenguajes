package interpreter;

import SLParser.*;

class Tipo {

}

class Const {

}

class Var {

}


public class MyVisitor<T> extends SLParserBaseVisitor<T> {

    StackedContextMap table = new StackedContextMap();




    @Override
    public T visitPrograma(SLParser.ProgramaContext ctx ) {

        //añadir declaraciones globales (CONSTS, VARIABLES, TIPOS)


        //añadir funciones a el ámbito de variables
        SLParser.SubrutinasContext subrutinas = ctx.subrutinas();
        for( SLParser.SubrutinaContext subrutina : subrutinas.subrutina() ) {
            table.put(subrutina.nombre_subrutina.getText(), subrutina);
        }
        visitChildren(ctx);
        return null;
    }

    @Override
    public T visitSubrutina(SLParser.SubrutinaContext ctx) {

    }
}
