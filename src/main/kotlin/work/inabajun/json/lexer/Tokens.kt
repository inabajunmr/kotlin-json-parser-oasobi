package work.inabajun.json.lexer

object RParenToken : Token
object LParenToken : Token
object RBracketToken : Token
object LBracketToken : Token
object CommaToken : Token
object ColonToken : Token
object EOFToken : Token
object NullToken : Token
object TrueToken : Token
object FalseToken : Token

class StringToken(val value: String) : Token {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StringToken

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "StringToken(value='$value')"
    }
}

class NumberToken(val value: Double) : Token {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NumberToken

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "NumberToken(value=$value)"
    }

}
