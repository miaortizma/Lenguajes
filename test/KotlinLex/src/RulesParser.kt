import java.io.File

data class TokenRule(val name: String, val regex: Regex)

class RulesParser {
    val rules: HashMap<String, TokenRule> by lazy { HashMap<String, TokenRule>() }

    private fun parseLine(line: String) {
        val args = "(?<rule>[A-Za-z_]+)[ |\t]*:[ |\t]*\"(?<regex>(?:.|\n|\r)*)\";".toRegex().find(line)?.groups

        val (rule, regex) = arrayOf(args?.get("rule")?.value, args?.get("regex")?.value)

        if (!rule.isNullOrBlank() && !regex.isNullOrBlank())
            rules.put(rule, TokenRule(rule, regex.toRegex()))
    }

    fun parse(file: File) {
        val inputStream = file.inputStream().reader()
        var char = 1
        var line: String

        while (char != -1) {
            line = buildString {
                while (true) {
                    char = inputStream.read()
                    when (char) {
                        '\n'.toInt(), '\t'.toInt(), ' '.toInt() -> Unit
                        ';'.toInt() -> {
                            append(char.toChar())
                            return@buildString
                        }
                        -1 -> return@buildString
                        else -> append(char.toChar())
                    }
                }
            }
            parseLine(line)
        }
    }
}