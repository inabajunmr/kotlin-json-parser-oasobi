package work.inabajun.json.lexer

/**
 * read next string token
 */
fun readNumber(l: Lexer): Token {
    val builder = StringBuilder()

    while (true) {
        if (isEndOfNumber(l)) {
            return NumberToken(builder.toString().toDouble())
        } else {
            builder.append(l.input[l.index])
            l.index++
        }
    }
}

fun isEndOfNumber(l: Lexer): Boolean {
    return when (l.input[l.index]) {
        ' ', '\n', '\r', '\t', '}', ',' -> true
        else -> false
    }
}
