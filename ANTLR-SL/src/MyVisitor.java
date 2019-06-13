public class MyVisitor<T> extends SLParserBaseVisitor<T> {

    StackedContextMap table = new StackedContextMap();

    @Override
    public T visitPrograma(SLParser.ProgramaContext ctx ) {
        SLParser.SubrutinasContext subrutinas = ctx.subrutinas();
        System.out.print("Hola Mundo\n");
        for( SLParser.SubrutinaContext subrutina : subrutinas.subrutina() ) {
            table.put(subrutina.nombre_subrutina.getText(), subrutina);
        }
        visitChildren(ctx);
        return null;
    }

}
