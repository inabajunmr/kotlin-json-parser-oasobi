package work.inabajun.json.lexer

enum class TokenType {
    LPAREN,
    RPAREN,
    LBRACKET,
    RBRACKET,
    COLON,
    COMMA,
    NUMBER,
    TRUE,
    FALSE,
    STRING,
    NULL,
    EOF
}