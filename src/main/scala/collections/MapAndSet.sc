val example = Map("a" -> 1, "b" -> 2, "c" -> 3)
example + ("d" -> 4)

val doubleValueMap = example.map(pair => pair._1 -> pair._2 * 2)

example.map(pair => pair._1 + "=" + pair._2)

example.flatMap {
  case (key, value) =>
    (1 to 3).map(x => (key + x) -> (value + x))
}

for {
  (str, value) <- example
  x <- (1 to 3)
} yield (str + x) -> (value * x)