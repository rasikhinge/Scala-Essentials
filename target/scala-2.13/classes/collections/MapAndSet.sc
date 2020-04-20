val example = Map("a" -> 1, "b" -> 2, "c" -> 3)
example + ("d" -> 4)

val doubleValueMap = example.map(pair => pair._1 -> pair._2 * 2)

example.map(pair => pair._1 + "=" + pair._2)