package Solutions.Leetcode_700

/*
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 */

class Solution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return root
        var nestStep = root
        while (nestStep != null){
            if (nestStep.`val`==`val`) return nestStep
            if (nestStep.`val` > `val`) nestStep = nestStep.left
            else nestStep = nestStep.right
        }
        return nestStep

    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}