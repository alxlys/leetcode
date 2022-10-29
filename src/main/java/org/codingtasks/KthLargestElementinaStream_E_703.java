package org.codingtasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * @author olysenko
 */
public class KthLargestElementinaStream_E_703 {

   public static void main(String[] args) {
      //Input
      //["KthLargest", "add", "add", "add", "add", "add"]
      //[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
      //Output
      //[null, 4, 5, 5, 8, 8]
      KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
      System.out.println(kthLargest.add(3));   // return 4
      System.out.println(kthLargest.add(5));   // return 5
      System.out.println(kthLargest.add(10));  // return 5
      System.out.println(kthLargest.add(9));   // return 8
      System.out.println(kthLargest.add(4));   // return 8
   }

   private static class KthLargest {

      private final Queue<Integer> heap = new PriorityQueue<>();
      private final int k;

      public KthLargest(int k, int[] nums) {
         this.k = k;
         for (int num : nums) {
            add(num);
         }
      }

      public int add(int val) {
         if (heap.size() < k) {
            heap.add(val);
         } else if (val > heap.peek()) {
            heap.poll();
            heap.add(val);
         }
         return heap.peek();
      }
   }


}
