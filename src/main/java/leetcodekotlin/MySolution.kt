package leetcodekotlin

import org.junit.Test
import java.util.*
import kotlin.math.max

/**
 * @author bruce ge 2021/3/25
 */
class MySolution {
    fun reversePrint(head: ListNode?): IntArray {
        if (head == null) {
            return intArrayOf();
        }
        val myStack = Stack<Int>()
        val i = head.`val`
        myStack.push(i);
        var next = head.next
        while (next != null) {
            myStack.push(next.`val`)
            next = next.next
        }
        var mutableListOf = mutableListOf<Int>()
        while (myStack.isNotEmpty()) {
            var pop = myStack.pop()
            mutableListOf.add(pop)
        }
        var toIntArray = mutableListOf.toIntArray()
        return toIntArray
    }


    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return mutableListOf()
        }
        var firstStack = mutableListOf<TreeNode>()
        firstStack.add(root)
        var result = mutableListOf<List<Int>>()
        addToResult(firstStack, result);
        return result
    }

    private fun addToResult(firstStack: MutableList<TreeNode>, result: MutableList<List<Int>>) {
        if (firstStack.isEmpty()) {
            return;
        }
        var nextList = mutableListOf<TreeNode>()
        var curretnResult = mutableListOf<Int>()
        firstStack.forEach {
            curretnResult.add(it.`val`)
            if (it.left != null) {
                nextList.add(it.left)
            }
            if (it.right != null) {
                nextList.add(it.right);
            }
        }
        result.add(curretnResult);
        addToResult(nextList, result);
    }


    fun maximum69Number(num: Int): Int {
        var a = num % 10
        var b = num / 10;
        var mutableListOf = mutableListOf<Int>()
        mutableListOf.add(a);
        while (b > 0) {
            a = b % 10
            b = b / 10;
            mutableListOf.add(a);
        }
        var asReversed = mutableListOf.asReversed()

        for (index in 0..asReversed.size - 1) {
            var get = asReversed.get(index)
            if (get == 6) {
                asReversed.set(index, 9)
                break
            }
        }
        var size = asReversed.size
        var sum = 0;
        asReversed.forEachIndexed { index, i ->
            var curretn = i;
            for (b in index + 1..size - 1) {
                curretn = curretn * 10;
            }
            sum = sum + curretn;
        }
        return sum;
    }


    fun firstMissingPositive(nums: IntArray): Int {
        var size = nums.size
        var intArray = IntArray(size + 1)
        for (i in 0..intArray.size - 1) {
            intArray[i] = -1;
        }
        for (num in nums) {
            if (num > size) {
                continue
            } else if (num <= 0) {
                continue;
            } else {
                intArray[num-1] = 1;
            }
        }
        for (k in 0..intArray.size - 1) {
            var i = intArray[k]
            if (i == -1) {
                return k+1;
            }
        }
        return size+1;
    }

    @Test
    fun testINtArrr(){
        println(firstMissingPositive(intArrayOf(1,2,0)))

        println(firstMissingPositive(intArrayOf(3,4,-1,1)))

        println(firstMissingPositive(intArrayOf(7,8,9,11,12)))
    }

    @Test
    fun testIt() {
        println(maximum69Number(9669))
        println(maximum69Number(9966))
    }
}
