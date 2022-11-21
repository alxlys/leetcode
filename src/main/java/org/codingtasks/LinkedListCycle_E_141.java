package org.codingtasks;

import java.util.Optional;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * @author olysenko
 */
public class LinkedListCycle_E_141 {

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
      LinkedListCycle_E_141 solution = new LinkedListCycle_E_141();
      //Input: head = [3,2,0,-4], pos = 1
      //Output: true
      //Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//      ListNode node2 = null;
//      System.out.println(solution.hasCycle(new ListNode(3, (node2 = new ListNode(2, new ListNode(0 , new ListNode(-4)))))));


      //Input: head = [1,2], pos = 0
      //Output: true
      //Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
   }

   public boolean hasCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
         if (slow == fast) {
            return true;
         }
      }
      return false;
   }

}
