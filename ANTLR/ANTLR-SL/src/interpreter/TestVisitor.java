package interpreter;

import gen.SLGrammarLexer;
import gen.SLGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class TestVisitor {
    public static void main(String[] args) {
        CharStream inputStream = null;
        try {
            inputStream = CharStreams.fromFileName(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CommonTokenStream commonTokenStream = new CommonTokenStream(new SLGrammarLexer(inputStream));
        SLGrammarParser parser = new SLGrammarParser(commonTokenStream);
        MyVisitor visitor = new MyVisitor<>();
        // System.out.println(parser.program().toStringTree());
        visitor.visit(parser.program());
    }
}
