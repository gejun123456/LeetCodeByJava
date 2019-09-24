package luogu


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P1014 {
}

fun main(args: Array<String>) {
    val (a) = readLine()!!.split(' ').map { it.toInt() }
    /*7 8 9 10都是4层 7是4层1号*/
    var s = 1;
    var step = 1;
    while (s < a) {
        //s代表每层开头的数字
        step = step + 1;
        s += step;
    }
    //计算他是第几个
    var sum = step+1;
    var count = (a -s +step)
    println("${sum-count}/${count}")
}
