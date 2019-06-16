import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun main(args: Array<String>) {
    if (args.isEmpty())
        return

    val lexer = SLGrammarLexer(CharStreams.fromFileName(args.first()))
    val tokens = CommonTokenStream(lexer)
    val parser = SLGrammarParser(tokens)

    // loadTokenNames()
    // lexer.allTokens.forEach { println(it.toS()) }

    print(parser.file().toStringTree())
}