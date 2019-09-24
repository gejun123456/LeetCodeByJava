package luogu


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P1421 {
}

fun main(args: Array<String>) {
    val map = readLine()!!.split(' ').map { it.toInt() }
    val c: Int = buySoft(map.get(0), map.get(1))
    println(c)
}

fun buySoft(a: Int, b: Int): Int {
    return (a * 10 + b) / 19
}
