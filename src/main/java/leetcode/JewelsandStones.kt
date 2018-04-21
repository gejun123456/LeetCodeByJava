package leetcode

import org.assertj.core.api.Assertions

/**
 * @Author bruce.ge
 * @Date 2018/4/21
 * @Description
 */
class JewelsandStones {
    fun numJewelsInStones(J: String, S: String): Int {
        var count = 0;
        for (aa in S) {
            for (bb in J) {
                if (aa == bb) {
                    count++;
                }
            }
        }
        return count;
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val jewelsandStones = JewelsandStones()
            val numJewelsInStones = jewelsandStones.numJewelsInStones("aA", "aAAbbbb");
            Assertions.assertThat(numJewelsInStones).isEqualTo(3);
            Assertions.assertThat(jewelsandStones.numJewelsInStones("z","ZZ")).isEqualTo(0);
        }
    }

}
