package base.luoguTest

import luogu.addAAndB
import luogu.buySoft
import luogu.getUsedTime
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


/**
 * pacakgeName base.luoguTest
 * @author bruce ge
 */
class LouguTest {
    @Test
    fun AAndB() {
        val addAAndB = addAAndB(1, 2)
        assertThat(addAAndB).isEqualTo(3)
    }

    @Test
    fun testBySoft() {
        assertThat(buySoft(10,3)).isEqualTo(5)
    }

    @Test
    fun testGetUsedTime() {
        val usedTime = getUsedTime(12, 50, 19, 10)
        assertThat(usedTime.first).isEqualTo(6)
        assertThat(usedTime.second).isEqualTo(20)
    }
}
