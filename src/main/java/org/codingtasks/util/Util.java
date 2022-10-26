package org.codingtasks.util;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author olysenko
 */
public class Util {

   public static <T> void printArray(T[] array) {
      System.out.println(Arrays.stream(array).collect(Collectors.toList()));
   }

   public static void printArray(int[] array) {
      printArray(Arrays.stream(array).boxed().toArray());
   }

   public static class ListNode {
      public int val;
      public ListNode next;

      public ListNode() {
      }

      public ListNode(int val) {
         this.val = val;
      }

      public ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
      }
   }

   public static void printNode(ListNode node) {
      StringBuilder builder = new StringBuilder("[");
      while (node != null) {
         builder.append(node.val);
         node = node.next;
         if (node != null) {
            builder.append(",");
         }
      }
      builder.append("]");
      System.out.println(builder.toString());
   }
}
