# kotlin-json-parser-oasobi
implements Kotlin json parser for fun

## Sample

```kotlin
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

val json = Parser(input).parse()
println(json.get("text").getText())
println(json.get("object")).get("childkey").getText())
println(json.get("int")).getInt())
println(json.get("double")).getDouble())
println(json.get("bool")).getBool())
println(json.get("null")).isNull())
println(json.get("array")).get(0).getInt())
println(json.get("array")).get(1).getText())
println(json.get("array")).get(2).getBool())
println(json.get("array")).get(3).get("arrayobj").getText())
```