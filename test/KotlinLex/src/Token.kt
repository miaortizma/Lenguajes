class Token(
    val type: String, val lexeme: String, val row: Int, val col: Int,
    val special: Boolean = false
) {
    constructor(type: String, row: Int, col: Int) : this(type, type, row, col, true)

    override fun toString(): String = if (special) "<${type}, ${row}, ${col}>"
    else "<${type}, ${lexeme}, ${row}, ${col}>"
}

fun main() {
    val token = Token("id", "id1", 2, 3)
    val special = Token("par_der", 2, 3)

    println(token)
    print(special)
}