package work.inabajun.json.parser

class ObjectNode(private val values: HashMap<String, Node>) : Node {
    override fun get(key: String): Node {
        return values[key] ?: throw NodeNotFoundException("Key:${key} is not found.")
    }
}

class ArrayNode(private val values: ArrayList<Node>) : Node {
    override fun get(key: Int): Node {
        return values[key]
    }
}

class TextNode(private val value: String) : Node {
    override fun getText(): String {
        return value
    }
}

class NumberNode(private val value: Double) : Node {
    override fun getDouble(): Double {
        return value
    }

    override fun getInt(): Int {
        return value.toInt()
    }
}

object TrueNode : Node {
    override fun getBool(): Boolean {
        return true
    }
}

object FalseNode : Node {
    override fun getBool(): Boolean {
        return false
    }
}

object NullNode : Node {
    override fun isNull(): Boolean {
        return true
    }
}
