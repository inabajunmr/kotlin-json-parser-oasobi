package work.inabajun.json.parser

interface Node {

    fun get(key:String) : Node {
        throw NodeUnsupportedException("This node ${this.javaClass.name} is not object.")
    }

    fun get(key:Int) : Node {
        throw NodeUnsupportedException("This node ${this.javaClass.name} is not object.")
    }

    fun getText() : String {
        throw NodeUnsupportedException("This node ${this.javaClass.name} is not text.")
    }

    fun getDouble() : Double {
        throw NodeUnsupportedException("This node ${this.javaClass.name} is not number.")
    }

    fun getInt() : Int {
        throw NodeUnsupportedException("This node ${this.javaClass.name} is not number.")
    }

    fun getBool() : Boolean {
        throw NodeUnsupportedException("This node ${this.javaClass.name} is not boolean.")
    }

    fun isNull() : Boolean {
        return false
    }

}