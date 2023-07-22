/*
Given the head of a singly linked list, return the middle node of the linked list. If the number of nodes in the linked list is even, there will be two middle nodes, so return the second one.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

*/


public class MiddleNode{
    public static LinkedListNode middleNode(LinkedListNode head) {
      LinkedListNode slow = head, fast = head;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }
}

// TC: O(n), SC: O(1)