package work.inabajun.json.lexer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LexerTest {

    @Test
    fun testGetNextToken() {
        // setup
        val lexer = Lexer(
            """
            { "key1" : "value1",
              "key2" : "value2" ,
              "key3" : "value3\"\\\/\b\f\n\r\t\u005C\uD834\uDD1E",
              "key4" : true, 
              "key5" : false, 
              "key6" : null,
              "key7" : 10,
              "key8" : 10.5,
              "key9" : +5,
              "key10" : -5,
              "key11" : 10e+1
            }
        """
        )

        // exercise and verify
        assertEquals(lexer.getNextToken(), LParenToken)
        assertEquals(lexer.getNextToken(), StringToken("key1"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), StringToken("value1"))
        assertEquals(lexer.getNextToken(), CommaToken)
        assertEquals(lexer.getNextToken(), StringToken("key2"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), StringToken("value2"))
        assertEquals(lexer.getNextToken(), CommaToken)
        assertEquals(lexer.getNextToken(), StringToken("key3"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), StringToken("value3\"\\/\b\u000C\n\r\t\\\uD834\uDD1E"))
        assertEquals(lexer.getNextToken(), CommaToken)
        assertEquals(lexer.getNextToken(), StringToken("key4"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), TrueToken)
        assertEquals(lexer.getNextToken(), CommaToken)
        assertEquals(lexer.getNextToken(), StringToken("key5"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), FalseToken)
        assertEquals(lexer.getNextToken(), CommaToken)
        assertEquals(lexer.getNextToken(), StringToken("key6"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), NullToken)
        assertEquals(lexer.getNextToken(), CommaToken)
        assertEquals(lexer.getNextToken(), StringToken("key7"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), NumberToken(10.0))
        assertEquals(lexer.getNextToken(), CommaToken)
        assertEquals(lexer.getNextToken(), StringToken("key8"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), NumberToken(10.5))
        assertEquals(lexer.getNextToken(), CommaToken)
        assertEquals(lexer.getNextToken(), StringToken("key9"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), NumberToken(5.0))
        assertEquals(lexer.getNextToken(), CommaToken)
        assertEquals(lexer.getNextToken(), StringToken("key10"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), NumberToken(-5.0))
        assertEquals(lexer.getNextToken(), CommaToken)
        assertEquals(lexer.getNextToken(), StringToken("key11"))
        assertEquals(lexer.getNextToken(), ColonToken)
        assertEquals(lexer.getNextToken(), NumberToken(100.0))
        assertEquals(lexer.getNextToken(), RParenToken)
        assertEquals(lexer.getNextToken(), EOFToken)
    }
}