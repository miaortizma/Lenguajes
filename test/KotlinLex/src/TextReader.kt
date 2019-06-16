import java.io.InputStream
import java.util.*

class TextReader(inputStream: InputStream) {
    private val queue: Queue<Char> = ArrayDeque<Char>()
    private val reader = inputStream.reader()
    private var actualChar = 0
    private var nextChar = reader.read()

    var row = 1
        private set
    var col = 0
        private set

    fun push(char: Char) {
        queue.offer(char)
        col--
        if (char == '\n')
            row--
    }

    fun next(): Char {
        fun consumeChar() {
            if (!queue.isEmpty()) {
                actualChar = queue.poll().toInt()
            } else {
                actualChar = nextChar
                nextChar = reader.read()
            }
            col++
        }

        consumeChar()

        if (actualChar == '\n'.toInt()) {
            row++; col = 0
        }

        return actualChar.toChar()
    }

    fun hasChars() = nextChar != -1
}