package luogu


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P1464 {
}

class Point(val a: Int, val b: Int, val c: Int) {
    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            if (other.a == this.a) {
                if ((other.b == this.b && other.c == this.c) || (other.b == this.c && other.c == this.b)) {
                    return true
                }
            }
        }
        return false
    }

    override fun hashCode(): Int {
        return (a * 100 + b * 10 + c) % 16
    }
}

fun main(args: Array<String>) {
    while (true) {
        val map = readLine()!!.split(" ").map { it.toInt() }

        val a = map.get(0)
        val b = map.get(1)
        val c = map.get(2)

        if (a == -1 && b == -1 && c == -1) {
            break;
        }
        val s: Int = calculate(a, b, c);
        println("w($a, $b, $c) = $s")
    }
}


fun calculate(a: Int, b: Int, c: Int): Int {
    val result =
            if (a <= 0 || b <= 0 || c <= 0) {
                1
            } else if (a > 20 || b > 20 || c > 20) {
                calculate(20, 20, 20)
            } else if (a <= b || a <= c) {
                var s = 1;
                for (i in 1..a) {
                    s = 2 * s;
                }
                return s;
            } else if (a < b && b < c) {
                calculate(a, b, c - 1) + calculate(a, b - 1, c - 1) - calculate(a, b - 1, c);
            } else {
                calculate(a - 1, b, c) + calculate(a - 1, b - 1, c) + calculate(a - 1, b, c - 1) - calculate(a - 1, b - 1, c - 1)

            }
    return result;

}
