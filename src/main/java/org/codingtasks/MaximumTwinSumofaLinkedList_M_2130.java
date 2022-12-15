package org.codingtasks;

/**
 * @author olysenko
 */
public class MaximumTwinSumofaLinkedList_M_2130 {

   private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
         next = null;
      }

      ListNode(int x, ListNode next) {
         this(x);
         this.next = next;
      }


      @Override
      public String toString() {
         return "ListNode{" + "val=" + val + ", next=" + next + '}';
      }
   }


   public static void main(String[] args) {
      MaximumTwinSumofaLinkedList_M_2130 solution = new MaximumTwinSumofaLinkedList_M_2130();
      //Input: head = [5,4,2,1]
      //Output: 6
      //Explanation:
      //Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
      //There are no other nodes with twins in the linked list.
      //Thus, the maximum twin sum of the linked list is 6.
      System.out.println(solution.pairSum(new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))))));

      //Input: head = [4,2,2,3]
      //Output: 7
      //Explanation:
      //The nodes with twins present in this linked list are:
      //- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
      //- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
      //Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
      System.out.println(solution.pairSum(new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3))))));


      //Input: head = [1,100000]
      //Output: 100001
      //Explanation:
      //There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
      System.out.println(solution.pairSum(new ListNode(1, new ListNode(100000))));

   }

   public int pairSum(ListNode head) {
      //find the middle
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
         if (slow == fast) {
            break;
         }
      }

      //reverse from the middle
      ListNode current = slow;
      ListNode previous = null;
      while (current != null) {
         ListNode newCurrent = current.next;
         current.next = previous;
         previous = current;
         current = newCurrent;
      }

      //calculate max sum
      int max = 0;
      ListNode firstPart = head;
      ListNode secondPart = previous;
      while (firstPart != null && secondPart != null) {
         max = Math.max(firstPart.val + secondPart.val, max);
         firstPart = firstPart.next;
         secondPart = secondPart.next;
      }
      return max;
   }

}
