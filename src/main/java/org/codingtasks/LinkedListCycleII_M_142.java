package org.codingtasks;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * @author olysenko
 */
public class LinkedListCycleII_M_142 {

   private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
         next = null;
      }
      @Override
      public String toString() {
         return "ListNode{" + "val=" + val + ", next=" + next + '}';
      }
   }

   public static void main(String[] args) {
      LinkedListCycleII_M_142 solution = new LinkedListCycleII_M_142();
      //
   }

   public ListNode detectCycle(ListNode head) {
      ListNode slow1 = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
         slow1 = slow1.next;
         fast = fast.next.next;
         if (slow1 == fast) {
            break;
         }
      }
      if (fast == null || fast.next == null) {
         return null;
      }
      ListNode slow2 = head;
      while (slow1 != slow2) {
         slow1 = slow1.next;
         slow2 = slow2.next;
      }
      return slow2;
   }

}
