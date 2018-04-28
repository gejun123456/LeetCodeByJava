package leetcode

import org.assertj.core.api.Assertions
import org.junit.Test

/**
 * @Author bruce.ge
 * @Date 2018/4/28
 * @Description
 */
class UniqueMorseCodeWords {
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val morseCodes = arrayOf(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..");

        var finalStringArrays: Array<String> = emptyArray();

        for (word in words) {
            var ss = "";
            for (c in word) {
                ss = ss + morseCodes[c - 'a'];
            }
            var find = 0;
            for (finalStringArray in finalStringArrays) {
                if (finalStringArray.equals(ss)) {
                    find = 1;
                    break;
                }
            }

            if (find == 0) {
                finalStringArrays = finalStringArrays.plusElement(ss);
            }
        }

        return finalStringArrays.size;
    }


    @Test
    fun testGetMore() {
        val data = arrayOf("gin", "zen", "gig", "msg");
        var result = uniqueMorseRepresentations(data);
        Assertions.assertThat(result).isEqualTo(2);
    }
}