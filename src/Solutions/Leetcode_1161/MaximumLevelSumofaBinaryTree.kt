package Solutions.Leetcode_1161

import java.util.*

/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */
class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) return -1
        var maxSum = Int.MIN_VALUE
        var maxLevel = 0
        val q: Queue<TreeNode> = LinkedList()
        var level = 0
        q.add(root)
        while (!q.isEmpty()) {
            var currentLevelSum = 0
            level++
            for (i in 0 until q.size) {
                val node = q.remove()
                currentLevelSum += node.`val`
                if (node.left != null) q.add(node.left)
                if (node.right != null) q.add(node.right)
            }
            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum
                maxLevel = level
            }
        }
        return maxLevel
    }
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}