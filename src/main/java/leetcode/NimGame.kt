package leetcode

/**
 * @Author bruce.ge
 * @Date 2018/4/28
 * @Description
 */
class NimGame {
    fun canWinNim(n: Int): Boolean {
        if (n % 4 == 0) {
            return false;
        } else {
            return true;
        }
    }
}