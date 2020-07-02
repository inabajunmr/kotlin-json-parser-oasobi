package work.inabajun.json.parser

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import work.inabajun.json.lexer.Lexer

internal class ParserTest {

    @Test
    fun testParse() {
        // setup
        val input = """
            {"text" : "value",
            "object" : { "childkey" : "childvalue" },
            "int" : 10,
            "double" : 10.5,
            "bool" : false,
            "null" : null,
            "array" : [1,"test",false, {"arrayobj":"arrayvalue"}]
            }
        """

        // exercise
        val actual = Parser(input).parse()

        // verify
        assertEquals(actual.get("text").getText(), "value")
        assertEquals((actual.get("object")).get("childkey").getText(), "childvalue")
        assertEquals((actual.get("int")).getInt(), 10)
        assertEquals((actual.get("double")).getDouble(), 10.5)
        assertEquals((actual.get("bool")).getBool(), false)
        assertEquals((actual.get("null")).isNull(), true)
        assertEquals((actual.get("array")).get(0).getInt(), 1)
        assertEquals((actual.get("array")).get(1).getText(), "test")
        assertEquals((actual.get("array")).get(2).getBool(), false)
        assertEquals((actual.get("array")).get(3).get("arrayobj").getText(), "arrayvalue")
    }
}