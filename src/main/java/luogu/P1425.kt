package luogu


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P1425 {
}

fun main(args: Array<String>) {
    val (a, b, c, d) = readLine()!!.split(' ').map { it.toInt() }
    val e: Pair<Int, Int> = getUsedTime(a, b, c, d)
    println("${e.first} ${e.second}")
}

fun getUsedTime(a: Int, b: Int, c: Int, d: Int): Pair<Int, Int> {
    val time = c * 60 + d - (a * 60 + b)
    val hour = time / 60;

    val miniute = time % 60;

    return Pair(hour, miniute)
}
