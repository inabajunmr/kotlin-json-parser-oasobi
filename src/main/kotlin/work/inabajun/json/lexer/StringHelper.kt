package work.inabajun.json.lexer

/**
 * read next string token
 */
fun readString(l: Lexer): Token {
    val builder = StringBuilder()

    while (true) {
        if (isEndOfString(l)) {
            l.index++
            return StringToken(builder.toString())
        } else {
            builder.append(readNextCharForString(l))
            l.index++
        }
    }
}

private fun readNextCharForString(l: Lexer): Char {
    val escape = l.input[l.index] == '\\'
    return if (!escape) {
        l.input[l.index]
    } else {
        l.index++
        return when (l.input[l.index]) {
            '\\' -> '\\'
            '"' -> '"'
            '/' -> '/'
            'b' -> '\b'
            'f' -> '\u000C'
            'n' -> '\n'
            'r' -> '\r'
            't' -> '\t'
            'u' -> readNextHex(l)
            else -> throw LexerException("This escaped sequence:${l.input[l.index]} is undefined.")
        }
    }
}

private fun readNextHex(l:Lexer) : Char{
    val char = String(
        charArrayOf(
            l.input[l.index + 1],
            l.input[l.index + 2],
            l.input[l.index + 3],
            l.input[l.index + 4]
        )
    ).toLong(radix = 16).toChar()
    l.index += 4
    return char
}

private fun isEndOfString(l: Lexer): Boolean {
    return l.input[l.index - 1] != '\\' && l.input[l.index] == '"'
}