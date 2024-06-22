package Solutions.Leetcode_215

import java.util.PriorityQueue

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>()

        for (i in nums){
            queue.add(i)
            if (queue.size > k) queue.poll()
        }
        return queue.poll()

    }
}