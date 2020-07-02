package work.inabajun.json.parser

import work.inabajun.json.lexer.*

class Parser(input: String) {

    val l = Lexer(input)
    public fun parse(): Node {
        return when (val token = l.getNextToken()) {
            is LParenToken -> parseObject()
            is StringToken -> TextNode(token.value)
            is NumberToken -> NumberNode(token.value)
            is TrueToken -> TrueNode
            is FalseToken -> FalseNode
            is NullToken -> NullNode
            is LBracketToken -> parseArray()
            else -> throw ParserException("TODO")
        }
    }

    private fun parseArray(): Node {
        val values = ArrayList<Node>()
        while (true) {
            values.add(parse())
            if (l.isNextComma()) {
                l.getNextToken()
                continue
            }
            break
        }

        val nextToken = l.getNextToken()
        if (nextToken !is RBracketToken) {
            throw ParserException("Array must enclose by ']'. ${nextToken.javaClass.name}")
        }

        return ArrayNode(values)
    }

    private fun parseObject(): Node {
        val values = HashMap<String, Node>()
        while (true) {
            val key = getObjectKey(l.getNextToken())
            if (l.getNextToken() !is ColonToken) {
                throw ParserException("JSON is invalid. Colon is needed after key.")
            }

            values[key] = parse()
            if (l.isNextComma()) {
                l.getNextToken()
                continue
            }
            break
        }
        if (l.getNextToken() !is RParenToken) {
            throw ParserException("Object must enclose by '}'.")
        }
        return ObjectNode(values)

    }

    private fun getObjectKey(token: Token): String {
        if (token is StringToken) {
            return token.value
        }

        throw ParserException("JSON is invalid. String is needed after '{'.")
    }

}