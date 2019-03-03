# Section 4: Data Types and Null Reference Handling
- Everthing is a class. 
- There is no lower case in Kotlin.

| Java | kotlin |
| ----- | ----- |
| int myInt = 10 | val myInt = 10 |
| Long myLong = myInt | var myLong = myInt.toLong() |
|  |  |
| byte myByte = 111 | val myByte: Byte = 111 |
| short myShort = myByte | var myShort: Short = myByte.toShort() |
|  |  |
| double myDouble = 65.984 | var myDouble = 65.984 => It is as Java |
|  |  |
| float myFloat = 838.8492f | val myFloat = 838.8492f |
| double myDouble = myFloat | val myDouble = myFloat.toDouble() |
|  |  |
| char myChar = 65 | val myCharInt = 65 (myCharInt.toChar()) |
|  |  |
|  | val anything: Any |
|  |  |
| void myMethod() {} | fun myMethod() {} (It return a singleton Unit instance) |
|  |  |
|  | fun fail(message: String): Nothing { throw IllegalArgumentException(message) } |

- Any

```
public open class Any public constructor() {
    public open operator fun equals(other: kotlin.Any?): kotlin.Boolean { /* compiled code */ }

    public open fun hashCode(): kotlin.Int { /* compiled code */ }

    public open fun toString(): kotlin.String { /* compiled code */ }
}

fun myMethod() {}
```

- Nothing
Use for a method return a infinit loop for exemple

```
public final class Nothing private constructor() {
}


fun fail(message: String) : Nothing { throw IllegalArgumentException(message)
}

fun infinitLoop() :  Nothing { for (;;) }
```

- Arrays






































