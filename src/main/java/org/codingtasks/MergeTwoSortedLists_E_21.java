package org.codingtasks;

import org.codingtasks.util.Util;

import static org.codingtasks.util.Util.*;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author olysenko
 */
public class MergeTwoSortedLists_E_21 {

   public static void main(String[] args) {
      MergeTwoSortedLists_E_21 solution = new MergeTwoSortedLists_E_21();

      // list1 = [1,2,4], list2 = [1,3,4]
      ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
      ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

      ListNode res1 = solution.mergeTwoLists(list1, list2);
      printNode(res1);

      // list1 = [], list2 = []
      list1 = null;
      list2 = null;

      ListNode res2 = solution.mergeTwoLists(list1, list2);
      printNode(res2);

      // list1 = [], list2 = [0]
      list1 = null;
      list2 = new ListNode(0);

      ListNode res3 = solution.mergeTwoLists(list1, list2);
      printNode(res3);
   }

   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode prev = null;
      ListNode first = null;
      while (true) {
         if (list1 == null && list2 == null) {
            break;
         }

         Integer l1 = list1 != null ? list1.val : null;
         Integer l2 = list2 != null ? list2.val : null;

         ListNode next;

         if (l1 != null && l2 != null) {
            if (l1 > l2) {
               next = list2;
               list2 = list2.next;
            } else {
               next = list1;
               list1 = list1.next;
            }
         } else if (l1 != null) {
            next = list1;
            list1 = list1.next;
         } else {
            next = list2;
            list2 = list2.next;
         }

         if (prev != null) {
            prev.next = next;
            prev = prev.next;
         } else {
            first = prev = next;
         }
      }
      return first;
   }

   public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
      final ListNode root = new ListNode();
      ListNode prev = root;
      while (list1 != null && list2 != null) {
         if (list1.val < list2.val) {
            prev.next = list1;
            list1 = list1.next;
         } else {
            prev.next = list2;
            list2 = list2.next;
         }
         prev = prev.next;
      }
      prev.next = list1 != null ? list1 : list2;
      return root.next;
   }

}
