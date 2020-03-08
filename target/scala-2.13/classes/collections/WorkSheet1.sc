val seq = Seq(1, 2, 3)

seq(0)
seq(1)

seq.apply(2)
seq.apply(3)

seq.head
seq.tail
seq.tail.head
Seq().head
Seq().tail
Seq().headOption
Seq(1).headOption

seq.contains(2)
seq.find(_ == 3)
seq.find(_ > 3)
seq.filter(_ > 1)

seq.sortWith((x, y) => x > y)
seq.sortWith(_ > _)
seq.sortWith((x, y) => x < y)
seq.sortWith(_ < _)

Nil
val list = 1 :: 2 :: 3 :: Nil
val list2 = 4 :: 5 :: list
list2 :+ 6
list.::(4)
4 :: list