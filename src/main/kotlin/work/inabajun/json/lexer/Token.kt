package work.inabajun.json.lexer

interface Token {
    fun getTokenType() : TokenType
}