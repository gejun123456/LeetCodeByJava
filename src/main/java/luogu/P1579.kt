package luogu


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P1579 {

}

fun main(args: Array<String>) {
    val (a) = readLine()!!.split(' ').map { it.toInt() }

    val calcuatePrime = calcuatePrime(a)

    var k = 0;
    for (index in calcuatePrime.indices) {
        val i = calcuatePrime[index]
        if (i == null) {
            k++
        }
    }

    val primeArray = Array<Int?>(k) { null };

    var s = 0;
    for (index in calcuatePrime.indices) {
        val i = calcuatePrime[index]
        if (i == null) {
            primeArray[s] = index;
            s++
        }
    }

    for (i in primeArray.indices) {
        for (j in primeArray.indices) {
            val firstValue = primeArray[i];

            val secondValue = primeArray[j];

            val thridNumber = a - firstValue!! - secondValue!!;

            if (thridNumber < 0) {
                break
            }
            if (calcuatePrime[thridNumber] == null) {
                //it is a prime too
                println("$firstValue $secondValue $thridNumber")
                return
            }
        }

    }
}

//计算a中的所有prime
fun calcuatePrime(a: Int): Array<Int?> {
    val arrayOfNulls = arrayOfNulls<Int>(a + 1)
    arrayOfNulls[0] = 1;
    arrayOfNulls[1] = 1;
    for (i in (2..a)) {
        for (j in (i..a)) {
            if (i * j > a) {
                break
            }
            arrayOfNulls[i * j] = 1;
        }
    }

    return arrayOfNulls;
}
