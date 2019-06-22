package interpreter;


public class Interpreter {

    public static void main(String[] args) throws Exception {
        SLGrammarLexer lexer;
        System.out.println(args[0]);
        if (args.length>0)
            lexer = new SLGrammarLexer(CharStreams.fromFileName(args[0]));
        else
            lexer = new SLGrammarLexer(CharStreams.fromStream(System.in));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SLGrammarParser parser = new SLGrammarParser(tokens);
        ParseTree tree = parser.program();

        MyVisitor<Object> loader = new MyVisitor<Object>();
        loader.visit(tree);
    }
}
