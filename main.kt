import java.io.File

val mechanics = Mechanics()
fun main(args: Array<String>) {
    var mode = "enc"
    var key = 0
    var data = ""
    var input = ""
    var algoritm = ""
    var output = ""
    for (i in args.indices) {
        when (args[i]) {
            "-key" -> key = args[i + 1].toInt()
            "-data" -> data = args[i + 1]
            "-mode" -> mode = args[i + 1]
            "-in" -> input = File(args[i + 1]).useLines { it.toList().toString() }
            "-out" -> output = args[i + 1]
            "-alg" -> algoritm = args[i + 1]
        }
    }
    input = input.replace("[", "")
    input = input.replace("]", "")
    when(data){
        "" -> data = when(input) {
            "" -> ""
            else -> input }
    }
    mechanics.menu(mode, key, data, output, algoritm)
}
