package Solutions.Leetcode_328

/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */

class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head != null) {

            var odd = head
            var even = head.next
            var evenStart = head.next


            while (even?.next!=null){
                odd?.next = odd?.next?.next
                even?.next = even?.next?.next

                odd = odd?.next
                even = even?.next

            }
            odd?.next = evenStart
        }
        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}