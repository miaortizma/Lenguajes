public class MyVisitor<T> extends SLParserBaseVisitor<T> {

    StackedContextMap table = new StackedContextMap();

    @Override
    public T visit(SLParser.C) {
        return null;
    }

}
