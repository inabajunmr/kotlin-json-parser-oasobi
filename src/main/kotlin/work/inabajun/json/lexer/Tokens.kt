package work.inabajun.json.lexer

object RParenToken : Token {
    override fun getTokenType(): TokenType {
        return TokenType.RPAREN
    }
}

object LParenToken : Token {
    override fun getTokenType(): TokenType {
        return TokenType.LPAREN
    }
}

object RBracketToken : Token {
    override fun getTokenType(): TokenType {
        return TokenType.RBRACKET
    }
}

object LBracketToken : Token {
    override fun getTokenType(): TokenType {
        return TokenType.LBRACKET
    }
}

object CommaToken : Token {
    override fun getTokenType(): TokenType {
        return TokenType.COMMA
    }
}

object ColonToken : Token {
    override fun getTokenType(): TokenType {
        return TokenType.COLON
    }
}

object EOFToken : Token {
    override fun getTokenType(): TokenType {
        return TokenType.EOF
    }
}

class StringToken(val value :String) : Token{
    override fun getTokenType(): TokenType {
        return TokenType.STRING
    }

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

class NumberToken(val value:Double) : Token {
    override fun getTokenType(): TokenType {
        return TokenType.NUMBER
    }

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

object NullToken:Token {
    override fun getTokenType(): TokenType {
        return TokenType.NULL
    }
}

object TrueToken:Token {
    override fun getTokenType(): TokenType {
        return TokenType.TRUE
    }
}

object FalseToken:Token {
    override fun getTokenType(): TokenType {
        return TokenType.FALSE
    }

}