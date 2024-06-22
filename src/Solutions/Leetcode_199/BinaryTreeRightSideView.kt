package Solutions.Leetcode_199

/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        fun goDown(root: TreeNode?, list: MutableList<Int>, level: Int){
            if (root == null) return
            else {
                if (level > list.size) list.add(root.`val`)
                goDown(root.right, list, level+1)
                goDown(root.left, list, level+1)
            }

        }
        goDown(root, result, 1)
        return result
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}