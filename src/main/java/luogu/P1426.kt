package luogu


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P1426 {
}

fun main(args: Array<String>) {
    val (s, x) = readLine()!!.split(' ').map { it.toInt() }

    val left = s - x;

    val right = s + x;

    var currentSpace = 0.0;

    var currentSpeed = 7.0;
    while (currentSpace < left) {
        currentSpace = currentSpace + currentSpeed
        currentSpeed = currentSpeed * 0.98
    }

    if(currentSpace+currentSpeed>right){
        println("n")
        return
    }

    println("y")


}
