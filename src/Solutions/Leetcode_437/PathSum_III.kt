package Solutions.Leetcode_437

/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */

class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {

        var counter = 0
        var map = hashMapOf(0L to 1)
        fun count(root: TreeNode?, sum: Long = 0L){
            if (root == null) return

            var newSum = sum + root.`val`
            counter += map[newSum - targetSum] ?: 0
            map[newSum] = (map[newSum]?: 0) + 1

            count(root.left, newSum)
            count(root.right, newSum)
            map[newSum] = (map[newSum]?: 0) - 1

        }

        count(root)
        return counter
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}