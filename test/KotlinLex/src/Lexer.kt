import java.io.File

class Lexer {
    private val rules: HashMap<String, TokenRule> by lazy {
        val parser = RulesParser()
        parser.parse(File("src/lexicon.lx"))
        parser.rules
    }

    val tokens = ArrayList<Token>()
    var error: LexicalError? = null

    fun analyze(file: File) {
        val textReader = TextReader(file.inputStream())
        var actualChar: Char

        while (textReader.hasChars()) {
            val row = textReader.row
            val col = textReader.col

            actualChar = textReader.next()

            if (actualChar == '\n' || actualChar == ' ' || actualChar == '\t') continue

            if (actualChar == '"' && readString(textReader)) continue

            if ("[a-zA-Zñ_]".toRegex() matches actualChar.toString()
                && readWord(textReader, actualChar)
            ) continue

            if ("[+0-9-]".toRegex() matches actualChar.toString() &&
                readNumber(textReader, actualChar)
            ) continue

            if (readOtherCharacters(textReader, actualChar)) continue

            error = LexicalError(row, col)
            return
        }
    }

    private fun readOtherCharacters(textReader: TextReader, actualChar: Char): Boolean {
        val row = textReader.row
        val col = textReader.col
        var nextChar = textReader.next()

        if (actualChar == '/')
            when (nextChar) {
                '*' -> {
                    do {
                        readUntil(textReader, '*', initial = '*')
                        nextChar = textReader.next()
                    } while (nextChar != '/')
                    return (nextChar == '/')
                }
                '/' -> {
                    readUntil(textReader, '\n', initial = '/')
                    return true
                }
            }

        rules.keys.forEach {
            if (it !in arrayOf("reserved", "id", "number")) {
                if (rules[it]!!.regex.matches(actualChar.toString() + nextChar.toString())) {
                    tokens += Token(rules[it]!!.name, row, col)
                    return true
                }
            }
        }

        textReader.push(nextChar)

        rules.keys.forEach {
            if (it !in arrayOf("reserved", "id", "number")) {
                if (rules[it]!!.regex.matches(actualChar.toString())) {
                    tokens += Token(rules[it]!!.name, row, col)
                    return true
                }
            }
        }

        return false
    }

    private fun readNumber(textReader: TextReader, initial: Char): Boolean {
        val row = textReader.row
        val col = textReader.col

        val integer = initial + readWhile(textReader, initial, "[+-]?[0-9]+".toRegex())

        if (integer.isEmpty() || !("[+-]?[0-9]+".toRegex() matches integer)) {
            return false
        }
        var decimal = ""
        var char = textReader.next()

        if (char == '.') {
            decimal = char + readWhile(textReader, char, "\\.[0-9]+".toRegex())
            if (decimal.isEmpty())
                return false
        } else
            textReader.push(char)

        var exponent = ""
        char = textReader.next()

        if (char == 'e' || char == 'E') {
            exponent += char.toString()
            char = textReader.next()
            if (!char.isDigit() || char != '+' || char != '-')
                return false
            exponent = char + readWhile(textReader, char, "[0-9]+".toRegex())
            if (exponent.isEmpty())
                return false
        } else
            textReader.push(char)

        val string = integer + decimal + exponent

        if (string.isNotEmpty() || rules["number"]!!.regex matches string) {
            tokens += Token("tk_number", string, row, col)
            return true
        }

        return false
    }

    private fun readWord(textReader: TextReader, initial: Char): Boolean {
        val row = textReader.row
        val col = textReader.col
        val string = initial + readWhile(textReader, initial, "[a-zA-Z0-9_ñ]+".toRegex())

        if (string.isNotEmpty())
            when {
                rules["reserved"]!!.regex matches string -> {
                    tokens += Token(string, row, col)
                    return true
                }
                rules["tk_boolean"]!!.regex matches string -> {
                    tokens += Token(rules["tk_boolean"]!!.name, string, row, col)
                    return true
                }
                rules["id"]!!.regex matches string -> {
                    tokens += Token(rules["id"]!!.name, string, row, col)
                    return true
                }
            }
        return false
    }

    private fun readWhile(
        textReader: TextReader,
        initialChar: Char,
        regex: Regex
    ): String = buildString {
        var actualChar: Char = initialChar

        while (textReader.hasChars()) {
            actualChar = textReader.next()
            val string = initialChar + this.toString() + actualChar
            if (!(regex matches string)) {
                break
            }
            append(actualChar)
        }

        if (!(regex matches initialChar + this.toString()))
            resetString(this.append(actualChar), textReader)
        else
            textReader.push(actualChar)
    }

    private fun readUntil(
        textReader: TextReader,
        vararg limitChars: Char,
        prohibitedChar: Char? = null,
        maxChars: Int? = null,
        initial: Char
    ): String {
        var counter = 1

        return buildString {
            // append(initial)
            var actualChar: Char = textReader.next()
            if (actualChar == prohibitedChar) {
                resetString(this, textReader)
                return@buildString
            }

            append(actualChar)
            counter++

            while (textReader.hasChars() && actualChar !in limitChars) {
                if (maxChars != null && counter++ <= maxChars) break
                actualChar = textReader.next()
                if (actualChar == prohibitedChar) {
                    resetString(this, textReader)
                    return@buildString
                }
                append(actualChar)
            }

            if (actualChar !in limitChars)
                resetString(this, textReader)
        }
    }

    private fun resetString(stringBuilder: StringBuilder, textReader: TextReader) {
        stringBuilder.forEach {
            textReader.push(it)
        }
        stringBuilder.setLength(0)
    }

    private fun readString(textReader: TextReader, initial: Char = '"'): Boolean {
        val row = textReader.row
        val col = textReader.col
        val string: String = readUntil(
            textReader, '"', prohibitedChar = '\n', maxChars = null,
            initial = initial
        )

        if (string.isEmpty())
            return false
        else {
            tokens += Token("tk_string", initial + string, row, col)
            return true
        }
    }
}

class LexicalError(val row: Int, val col: Int, message: String = "") : Error(message) {
    override fun toString() = ">>> Lexical error: (row: $row, col: $col) $message"
}

fun main() {
    val lexer = Lexer()
    lexer.analyze(File("src/samples/s5.txt"))
    lexer.tokens.forEach {
        println(it)
    }

    if (lexer.error != null)
        println(lexer.error)
}