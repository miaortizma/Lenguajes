import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class Interpreter {

    public static void main(String[] args) throws Exception {
        SLLexer lexer;
        System.out.println(args[0]);
        if (args.length>0)
            lexer = new SLLexer(CharStreams.fromFileName(args[0]));
        else
            lexer = new SLLexer(CharStreams.fromStream(System.in));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SLParser parser = new SLParser(tokens);
        ParseTree tree = parser.commands();

        MyVisitor<Object> loader = new MyVisitor<Object>();
        loader.visit(tree);
    }
}
