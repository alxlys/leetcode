package org.codingtasks;

import org.codingtasks.util.Util;
import org.codingtasks.util.Util.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * @author olysenko
 */
public class ReverseLinkedList_E_206 {

   public static void main(String[] args) {
      ReverseLinkedList_E_206 solution = new ReverseLinkedList_E_206();
      // Input: head = [1,2,3,4,5]
      // Output: [5,4,3,2,1]
      ListNode res =
            solution.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
      Util.printNode(res);

      ListNode resR = solution
            .reverseListRecursive(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
      Util.printNode(resR);

      // Input: head = [1,2]
      // Output: [2,1]
      res = solution.reverseList(new ListNode(1, new ListNode(2)));
      Util.printNode(res);

      resR = solution.reverseList(new ListNode(1, new ListNode(2)));
      Util.printNode(resR);

      // Input: head = []
      // Output: []
      res = solution.reverseList(new ListNode());
      Util.printNode(res);

      resR = solution.reverseList(new ListNode());
      Util.printNode(resR);
   }

   public ListNode reverseList(ListNode head) {
      ListNode previous = null;
      ListNode current = head;
      while (current != null) {
         ListNode newCurrent = current.next;
         current.next = previous;
         previous = current;
         current = newCurrent;
      }
      return previous;
   }

   public ListNode reverseListRecursive(ListNode head) {
      return rev(head, null);
   }

   public ListNode rev(ListNode node, ListNode pre) {
      if (node == null) {
         return pre;
      }
      ListNode temp = node.next;
      node.next = pre;
      return rev(temp, node);
   }
}
