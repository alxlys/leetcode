package org.codingtasks;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author olysenko
 */
public class RemoveElement_E_27 {
   // https://leetcode.com/problems/remove-element/

   public static void main(String[] args) {
      RemoveElement_E_27 solution = new RemoveElement_E_27();
      int nums[] = new int[] { 3, 2, 2, 3 };
      int val = 3;
      int k = solution.removeElement(nums, val);
      System.out.println("After: " + Arrays.stream(nums).boxed().collect(Collectors.toList()) + " k: " + k);

      int nums1[] = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
      int val1 = 2;
      int k1 = solution.removeElement(nums1, val1);
      System.out.println("After: " + Arrays.stream(nums1).boxed().collect(Collectors.toList()) + " k: " + k1);
   }

   public int removeElement(int[] nums, int val) {
      int length = nums.length;
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] == val && i < length) {
            System.arraycopy(nums, i + 1, nums, i, length - i - 1);
            length--;
            i--;
         }
      }
      return length;
   }

}
