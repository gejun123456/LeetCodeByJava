package luogu


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P1422 {
}

fun main(args: Array<String>) {
    val (a) = readLine()!!.split(' ').map { it.toInt() }
    val s: Double = calucate(a);
    println("%.1f".format(s))
}

fun calucate(a: Int): Double {
    var result = 0.0;
    if (a >= 401) {
        result += (a - 400) * 0.5663
        result += (400 - 150) * 0.4663
        result += 150 * 0.4463;
        return result;
    }
    if (a >= 151) {
        result += 150 * 0.4463;
        result += (a - 150) * 0.4663
        return result
    } else {
        result = a * 0.4463
        return result
    }
}
