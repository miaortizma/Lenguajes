package interpreter;

import gen.SLGrammarLexer;
import gen.SLGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Interpreter {

    public static void main(String[] args) throws IOException {
        SLGrammarLexer lexer;
        System.out.println(args[0]);
        if (args.length > 0)
            lexer = new SLGrammarLexer(CharStreams.fromFileName(args[0]));
        else
            lexer = new SLGrammarLexer(CharStreams.fromStream(System.in));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SLGrammarParser parser = new SLGrammarParser(tokens);
        ParseTree tree = parser.program();

        MyVisitor<Object> loader = new MyVisitor<>();
        loader.visit(tree);
    }
}
