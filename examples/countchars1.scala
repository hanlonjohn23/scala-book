import scala.io.Source

// First pass

// if (args.length > 0) {
//   for (line <- Source.fromFile(args(0)).getLines())
//     println(line.length.toString + " " + line)
// }
// else
//   Console.err.println("Please enter filename")

// maxWidth using for for loop

// var maxWidth = 0
// for (line <- lines)
//   maxWidth = maxWidth.max(widthOfLength(line))

if (args.length > 0) {

  val lines = Source.fromFile(args(0)).getLines().toList

  def widthOfLength(s: String) = s.length.toString.length


  val longestLine = lines.reduceLeft(
    (a, b) => if (a.length > b.length) a else b
  )

  val maxWidth = widthOfLength(longestLine)

  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }
}
else
  Console.err.println("Please enter filename")