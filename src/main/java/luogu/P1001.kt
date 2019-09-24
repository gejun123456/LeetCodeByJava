package luogu

import org.assertj.core.api.Assertions
import org.junit.Test


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P1001 {


}

fun main(args: Array<String>) {
    val map = readLine()!!.split(' ').map { it.toInt() }
    println(addAAndB(map.get(0), map.get(1)))
}


fun addAAndB(a: Int, b: Int): Int {
    return a + b;
}


