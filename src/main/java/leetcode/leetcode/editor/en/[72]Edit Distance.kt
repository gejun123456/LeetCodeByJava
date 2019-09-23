package leetcode.leetcode.editor.en

import com.google.common.base.Stopwatch
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.TimeUnit

//Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
// You have the following 3 operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
//
//动态规划问题
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
// Related Topics String Dynamic Programming


class EditDistance {

    //leetcode submit region begin(Prohibit modification and deletion)

    data class Point(val a: Int, val b: Int, val c: Int, val d: Int)
    class Solution {
        fun minDistance(word1: String, word2: String): Int {
            val mutableMapOf = mutableMapOf<Point, Int>()
            val len1 = word1.length;
            val len2 = word2.length
//            return calucate(word1, 0, len1, word2, 0, len2,mutableMapOf);
            val arrayOf = arrayOfNulls<Array<Int?>>(len1 + 1)

            for (i in 0..len1) {
                arrayOf[i] = arrayOfNulls<Int>(len2 + 1);
                arrayOf[i]!![0] = i;
            }
            for (i in (0..len2)) {
                arrayOf[0]!![i] = i;
            }
            for (i in (1..len1)) {
                for (j in (1..len2)) {
                    val c = word1[i - 1]
                    val c1 = word2[j - 1]
                    val i1 = arrayOf[i - 1]!![j - 1]
                    var min = if (c == c1) {
                        i1!!
                    } else {
                        i1!! + 1
                    }
                    val i2 = arrayOf[i - 1]!![j]!! + 1
                    val i3 = arrayOf[i]!![j - 1]!! + 1
                    if (i2!! < min) {
                        min = i2;
                    }
                    if (i3!! < min) {
                        min = i3;
                    }
                    arrayOf[i]!![j] = min;
                }
            }

            return arrayOf[len1]!![len2]!!;
        }

        fun calucate(firstWord: String, firstStart: Int, firstEnd: Int, secondWord: String, secondStart: Int, secondEnd: Int, mutableMapOf: MutableMap<Point, Int>): Int {
            val point = Point(firstStart, firstEnd, secondStart, secondEnd)
            if (mutableMapOf.containsKey(point)) {
                return mutableMapOf.get(point)!!;
            }
            if (firstEnd == firstStart) {
                return secondEnd - secondStart;
            } else if (secondEnd == secondStart) {
                return firstEnd - firstStart;
            }

            if (firstEnd - firstStart == 1 && secondEnd - secondStart == 1) {
                val c = firstWord[firstStart]
                val c1 = secondWord[secondStart]
                if (c == c1) {
                    return 0;
                } else {
                    return 1;
                }
            }

            if (firstEnd - firstStart == 1) {
                val c = firstWord[firstStart]
                val substring = secondWord.substring(secondStart, secondEnd)
                if (substring.contains(c)) {
                    return secondEnd - secondStart - 1
                } else {
                    return secondEnd - secondStart
                }
            }

            if (secondEnd - secondStart == 1) {
                val c = secondWord[secondStart]
                val substring = firstWord.substring(firstStart, firstEnd)
                if (substring.contains(c)) {
                    return firstEnd - firstStart - 1
                } else {
                    return firstEnd - firstStart
                }
            }

            var min = Int.MAX_VALUE;
            for (m in (firstStart + 1..firstEnd - 1)) {
                for (d in (secondStart..secondEnd - 1)) {
                    val ddd = calucate(firstWord, firstStart, m, secondWord, secondStart, d + 1, mutableMapOf);
                    if (ddd > min) {
                        continue
                    }
                    val calucate = calucate(firstWord, m, firstEnd, secondWord, d + 1, secondEnd, mutableMapOf)
                    val cc = ddd + calucate;
                    if (cc < min) {
                        min = cc;
                    }
                }
            }
            mutableMapOf.put(Point(firstStart, firstEnd, secondStart, secondEnd), min)
            return min
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    fun testMinDistance() {
        val solution = EditDistance.Solution()


        assertThat(solution.minDistance("a", "a")).isEqualTo(0)



        assertThat(solution.minDistance("a", "ab")).isEqualTo(1)


        assertThat(solution.minDistance("abc", "ab")).isEqualTo(1)


        assertThat(solution.minDistance("abc", "bc")).isEqualTo(1)


        assertThat(solution.minDistance("abc", "c")).isEqualTo(2)


        assertThat(solution.minDistance("abc", "ac")).isEqualTo(1)


        assertThat(solution.minDistance("abcd", "ac")).isEqualTo(2)


        assertThat(solution.minDistance("abcd", "ab")).isEqualTo(2)

        assertThat(solution.minDistance("abcd", "ad")).isEqualTo(2)


        assertThat(solution.minDistance("abcd", "cd")).isEqualTo(2)

        assertThat(solution.minDistance("abcd", "d")).isEqualTo(3)
        assertThat(solution.minDistance("abc", "e")).isEqualTo(3)
        assertThat(solution.minDistance("abcd", "e")).isEqualTo(4)


        assertThat(solution.minDistance("abc", "acb")).isEqualTo(2)


        assertThat(solution.minDistance("abc", "ef")).isEqualTo(3)


        assertThat(solution.minDistance("abc", "def")).isEqualTo(3)

        assertThat(solution.minDistance("abcd", "ef")).isEqualTo(4)


        val minDistance = solution.minDistance("intention", "execution")
        assertThat(minDistance).isEqualTo(5)



        assertThat(solution.minDistance("dinitrophenylhydrazine",
                "acetylphenylhydrazine")).isEqualTo(6)


        val createStarted = Stopwatch.createStarted()
        assertThat(solution.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis",
                "stereomicroscopically")).isEqualTo(30)
        println("elpse in millSecond is:" + createStarted.elapsed(TimeUnit.MILLISECONDS))
        /*use dynamic step anlysi
        * a[i][j] = a[i-1][j]  a[i][j-1]  how to deal with it
        *
        * a    b  is one when b change to ba is 1 when b change to bc is 2
        *
        *
        *
        * */
    }

}





