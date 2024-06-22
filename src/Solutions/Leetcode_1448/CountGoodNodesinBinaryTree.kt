package Solutions.Leetcode_1448

/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
 */

class Solution {

    fun goodNodes(root: TreeNode?): Int {
        var counter = 0

        fun isGood(root: TreeNode?, maxI: Int){
            if (root == null) return
            if (maxI <= root.`val`) {
                counter++
            }
            maxOf(maxI, root.`val`).let {
                isGood(root.right, it)
                isGood(root.left, it)
            }
        }

        isGood(root, Int.MIN_VALUE)
        return counter
    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}