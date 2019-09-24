package luogu


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P1478 {
}


fun main(args: Array<String>) {
    val (appCount, strength) = readLine()!!.split(' ').map { it.toInt() }

    val (ladderHeight, height) = readLine()!!.split(' ').map { it.toInt() }

    val mutableListOf = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until appCount) {
        val (appHeight, appStrength) = readLine()!!.split(' ').map { it.toInt() }
        mutableListOf.add(Pair(appHeight, appStrength))
    }

    //
    val map = mutableListOf.map {
        val appheight = it.first
        if (appheight > ladderHeight + height) {
            10000
        } else {
            it.second
        }
    }

    val sorted = map.sorted()

    var s = 0;
    for (index in sorted.indices) {
        val i = sorted[index]
        s += i;

        if (s > strength) {
            println(index)
            return;
        }
    }

    println(sorted.size)
}
