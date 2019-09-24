package luogu

import java.lang.StringBuilder


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P2089 {
}


//算出 1* a  + 2*b + 3(10-a-b) = m 的所有值  先算出所有a b 值 然后根据ab 来进行排列
fun main(args: Array<String>) {
    val (a) = readLine()!!.split(' ').map { it.toInt() }

    val k = 0;
    val mutableListOf = mutableListOf<Pair<Int, Int>>()
    for (i in (0..10)) {
        for (j in (0..10)) {
            if (i + j > 10) {
                break
            }
            val c = (10 - i - j);
            val m = i * 1 + j * 2 + c * 3;
            if (m == a) {
                //怎么画出来 打印出所有的排列 10个里面有3个  用递归来写
                mutableListOf.add(Pair(i, j))

            }
        }
    }
    if (mutableListOf.isEmpty()) {
        println(0)
    } else {
        val result = mutableListOf<String>()
        for (pair in mutableListOf) {
            startToPrint(mutableListOf(Pair(1, pair.first), Pair(2, pair.second), Pair(3, 10 - pair.first - pair.second)), result, "")
        }
        println(result.size)
        result.sortBy { it }
        for (s in result) {
            print(s)
        }
    }
}

fun startToPrint(mutableListOf: MutableList<Pair<Int, Int>>, result: MutableList<String>, builder: String) {
    val filter = mutableListOf.filter { it.second > 0 };

    if (filter.isEmpty()) {
        result.add(builder + "\n")
        return
    }

    for (index in filter.indices) {
        val pair = filter[index]
        val mutableListOf1 = mutableListOf<Pair<Int, Int>>()
        for (thePair in mutableListOf) {
            if (thePair.first == pair.first) {
                mutableListOf1.add(Pair(pair.first, pair.second - 1))
            } else {
                mutableListOf1.add(Pair(thePair.first, thePair.second));
            }

            mutableListOf1.sortBy { it.first }
        }
        startToPrint(mutableListOf1, result, "$builder${pair.first} ");
    }
}


