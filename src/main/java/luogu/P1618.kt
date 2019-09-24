package luogu


/**
 * pacakgeName luogu
 * @author bruce ge
 */
class P1618 {
}

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }

   calcuate(a, b, c)

}

fun calcuate(a: Int, b: Int, c: Int){
    var count = 0;
    for (i in 1..3) {
        for (j in 1..9) {
            for (k in 1..9) {
                if (i != j && j != k) {
                    val firstWord = i * 100 + j * 10 + k

                    val i1 = firstWord * b % a

                    if (i1 != 0) {
                        continue
                    }

                    val i2 = firstWord * c % a
                    if (i2 != 0) {
                        continue
                    }
                    val secondWord = firstWord * b / a

                    if(secondWord>987){
                        continue
                    }

                    var thridWord = firstWord * c / a


                    if(thridWord>987){
                        continue
                    }


                    val firstWordArray = intArrayOf(firstWord % 10, firstWord % 100 / 10, firstWord / 100)


                    val secondWordArray = intArrayOf(secondWord % 10, secondWord % 100 / 10, secondWord / 100)

                    if(secondWordArray.contains(0)){
                        continue
                    }

                    val thirdWordArray = intArrayOf(thridWord % 10, thridWord % 100 / 10, thridWord / 100)

                    if(thirdWordArray.contains(0)){
                        continue
                    }

                    val arrayOfNulls = arrayOfNulls<Int>(9)

                    firstWordArray.forEach { arrayOfNulls[it-1]=1 }


                    thirdWordArray.forEach {arrayOfNulls[it-1]=1 }


                    secondWordArray.forEach { arrayOfNulls[it-1]=1}

                    if (arrayOfNulls.filter { it==null }.isNotEmpty()) {
                        continue
                    }

                    println("$firstWord $secondWord $thridWord")

                    count++;

                }
            }
        }
    }

    if(count==0){
        println("No!!!")
    }
}
