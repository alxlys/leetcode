package org.codingtasks;

import org.codingtasks.util.Util;
import org.codingtasks.util.Util.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * @author olysenko
 */
public class MergekSortedLists_H_23 {

   public static void main(String[] args) {
      MergekSortedLists_H_23 solution = new MergekSortedLists_H_23();
      //Input: lists = [[1,4,5],[1,3,4],[2,6]]
      //Output: [1,1,2,3,4,4,5,6]
      ListNode[] nodes = new ListNode[] { new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6)) };
      Util.printNode(solution.mergeKLists(nodes));
   }

   public ListNode mergeKLists(ListNode[] lists) {
      ListNode currentNode = null;
      ListNode head = null;
      while (true) {
         ListNode minNode = null;
         int minNodeIdx = 0;
         int minNodeValue = Integer.MAX_VALUE;
         for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            if (current == null) {
               continue;
            }
            if (current.val < minNodeValue) {
               minNode = current;
               minNodeValue = minNode.val;
               minNodeIdx = i;
            }
         }
         if (minNode == null) {
            break;
         }
         if (head == null) {
            head = minNode;
            currentNode = head;
         } else {
            currentNode.next = minNode;
            currentNode = minNode;
         }
         lists[minNodeIdx] = minNode.next;
      }
      return head;
   }

   public ListNode mergeKLists1(ListNode[] lists) {
      Queue<Integer> minHeap = new PriorityQueue<>();

      for (ListNode nodes : lists) {
         ListNode current = nodes;
         while (current != null) {
            minHeap.add(current.val);
            current = current.next;
         }
      }

      ListNode dummy = new ListNode(0);
      ListNode current = dummy;

      while (!minHeap.isEmpty()) {
         current.next = new ListNode(minHeap.poll());
         current = current.next;
      }

      return dummy.next;
   }

   public ListNode mergeKLists2(ListNode[] lists) {
      int size = lists.length;
      int interval = 1;

      while (interval < size) {
         for (int i = 0; i < size - interval; i += 2 * interval) {
            lists[i] = merge(lists[i], lists[i + interval]);
         }

         interval *= 2;
      }

      return size > 0 ? lists[0] : null;
   }

   private ListNode merge(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode curr = dummy;

      while (l1 != null && l2 != null) {
         if (l1.val <= l2.val) {
            curr.next = l1;
            l1 = l1.next;
         } else {
            curr.next = l2;
            l2 = l2.next;
         }

         curr = curr.next;
      }

      if (l1 != null) {
         curr.next = l1;
      } else {
         curr.next = l2;
      }

      return dummy.next;
   }

}
