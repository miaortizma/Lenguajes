import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.Token
import java.io.File

fun String.strip() = this.replace(" ", "")

fun Token.toS() =
    "${this.line}, ${this.startIndex}:${this.stopIndex}, ${this.text}, <${tokenNames[this.type]}>"

val tokenNames = HashMap<Int, String>()
fun loadTokenNames(): HashMap<Int, String> {
    File("grammar/SLGrammarLexer.tokens").forEachLine {
        if (it[0] != '\'') {
            val (name, id) = it.split("=")
            tokenNames += id.toInt() to name.strip()
        }
    }
    return tokenNames
}

fun main(args: Array<String>) {
    if (args.isEmpty())
        return

    loadTokenNames()
    val lexer = SLGrammarLexer(CharStreams.fromFileName(args.first()))
    lexer.allTokens.forEach { println(it.toS()) }
}