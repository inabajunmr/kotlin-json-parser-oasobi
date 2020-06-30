package work.inabajun.json.lexer

class Lexer(input: String) {

    val input: String = input

    var index = 0

    fun getNextToken(): Token {

        if (input.length <= index) {
            return EOFToken
        }

        val token = when (val c = input[index]) {
            ' ', '\n', '\r', '\t' -> {
                // skip whitespace
                index++
                return getNextToken()
            }
            '{' -> LParenToken
            '}' -> RParenToken
            '[' -> LBracketToken
            ']' -> LBracketToken
            ',' -> CommaToken
            ':' -> ColonToken
            '"' -> {
                index++
                return readString(this)
            }
            else -> {
                if (isNull()) {
                    index += 4
                    return NullToken
                }

                if (isTrue()) {
                    index += 4
                    return TrueToken
                }

                if (isFalse()) {
                    index += 5
                    return FalseToken
                }

                if (c in '0'..'9' || c == '+' || c == '-') {
                    return readNumber(this)
                }

                throw LexerException("Unexpected value:$c.")
            }
        }
        index++
        return token
    }

    private fun isNull(): Boolean {
        if (input.length < index + 3) {
            return false
        }

        return input[index] == 'n' && input[index + 1] == 'u' && input[index + 2] == 'l' && input[index + 3] == 'l'
    }

    private fun isTrue(): Boolean {
        if (input.length < index + 3) {
            return false
        }

        return input[index] == 't' && input[index + 1] == 'r' && input[index + 2] == 'u' && input[index + 3] == 'e'
    }

    private fun isFalse(): Boolean {
        if (input.length < index + 4) {
            return false
        }

        return input[index] == 'f' && input[index + 1] == 'a' && input[index + 2] == 'l' && input[index + 3] == 's' && input[index + 4] == 'e'
    }
}