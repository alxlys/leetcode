package org.codingtasks;

import org.codingtasks.util.Util;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author olysenko
 */
public class RemoveDuplicates_E_26 {

   public static void main(String[] args) {
      RemoveDuplicates_E_26 solution = new RemoveDuplicates_E_26();
      // 1
      int nums[] = { 1, 1, 2 };
      System.out.println("Before: ");
      Util.printArray(nums);
      int k = solution.removeDuplicates(nums);
      System.out.println("After: ");
      Util.printArray(nums);
      System.out.println("k = " + k);

      // 2
      int nums1[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
      System.out.println("Before: ");
      Util.printArray(nums1);
      int k1 = solution.removeDuplicates(nums1);
      System.out.println("After: ");
      Util.printArray(nums1);
      System.out.println("k = " + k1);
   }

   public int removeDuplicates(int[] nums) {
      if (nums.length > 1) {
         int length = nums.length;
         for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
               System.arraycopy(nums, i + 1 , nums, i, length - i - 1);
               length--;
               i--;
            }
         }
         return length;
      } else {
         return 1;
      }
   }
}
