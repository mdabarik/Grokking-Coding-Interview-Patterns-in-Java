/*
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int count = 0;
        ListNode front = null;
        ListNode end = null;
        ListNode curr = head;
        while (curr != null) {
            count += 1;
            if (end != null) {
                end = end.next;
            }
            if (count == k) {
                front = curr;
                end = head;
            }
            curr = curr.next;
        }
        int tmp = front.val;
        front.val = end.val;
        end.val = tmp;
        return head;
    }
}