/*
Given a singly linked list with n nodes and two positions, left and right, the objective is to reverse the nodes of the list from left to right. Return the modified list.
*/


public class ReverseLinkedList {
  public static LinkedListNode reverseBetween (LinkedListNode head, int left, int right) {
    if (head == null) return null;

    LinkedListNode curr = head, prev = null;
    while (left > 1) {
      prev = curr;
      curr = curr.next;
      left -= 1;
      right -= 1;
    }

    LinkedListNode con = prev, tail = curr;
    LinkedListNode third = null;
    while (right > 0) {
      third = curr.next;
      curr.next = prev;
      prev = curr;
      curr = third;
      right -= 1;
    }

    if (con != null) {
      con.next = prev; 
    } else {
      head = prev;
    }

      tail.next = curr;

    return head;
  }
}
