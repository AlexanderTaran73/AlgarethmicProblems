package Solutions.Leetcode_872

/*
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */

class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        var list1 = arrayListOf<Int>()
        var list2 = arrayListOf<Int>()

        getLeafValue(root1, list1)
        getLeafValue(root2, list2)

        if (list1.size != list2.size) return false
        for(i in 0..list1.size-1){
            if (list1[i]!=list2[i])return false
        }
        return true
    }

    fun getLeafValue(tree: TreeNode?, list: ArrayList<Int>){
        if (tree == null) return
        if (tree.left == null && tree.right == null) list.add(tree.`val`)
        else {
            getLeafValue(tree.left, list)
            getLeafValue(tree.right, list)
        }
    }
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}