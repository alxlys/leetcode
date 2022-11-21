package org.codingtasks;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @author olysenko
 */
public class MiddleoftheLinkedList_E_876 {

   private static class ListNode {
      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
         this.val = val;
      }

      ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
      }

      @Override
      public String toString() {
         return "ListNode{" + "val=" + val + ", next=" + next + '}';
      }
   }


   public static void main(String[] args) {
      MiddleoftheLinkedList_E_876 solution = new MiddleoftheLinkedList_E_876();
      //Input: head = [1,2,3,4,5]
      //Output: [3,4,5]
      //Explanation: The middle node of the list is node 3.
      System.out.println(
            solution.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));

      //Input: head = [1,2,3,4,5,6]
      //Output: [4,5,6]
      //Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
      System.out.println(solution.middleNode(
            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
   }

   public ListNode middleNode(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }
      return slow;
   }

}
