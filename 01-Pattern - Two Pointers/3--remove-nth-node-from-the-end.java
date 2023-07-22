/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        dfs(newHead, n + 1);
        return newHead.next;
    }
    public int dfs(ListNode node, int k) {
        if (node == null) return 0;
        int index = 1 + dfs(node.next, k);
        if (index == k) {
            node.next = node.next.next;
        }
        return index;
    }
} // TC: O(n), SC: O(n)