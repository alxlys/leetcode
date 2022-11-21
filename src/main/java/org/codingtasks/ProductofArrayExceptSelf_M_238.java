package org.codingtasks;

import org.codingtasks.util.Util;

/**
 * @author olysenko
 */
public class ProductofArrayExceptSelf_M_238 {

   public static void main(String[] args) {
      ProductofArrayExceptSelf_M_238 solution = new ProductofArrayExceptSelf_M_238();
      //Input: nums = [1,2,3,4]
      //Output: [24,12,8,6]
      Util.printArray(solution.productExceptSelf(new int[] { 1, 2, 3, 4 }));

      //Input: nums = [-1,1,0,-3,3]
      //Output: [0,0,9,0,0]
      Util.printArray(solution.productExceptSelf(new int[] { -1, 1, 0, -3, 3 }));

   }

   public int[] productExceptSelf(int[] nums) {
      int[] output = new int[nums.length];
      int leftPow = 1;
      int rightPow = 1;
      for (int i = 0; i < nums.length; i++) {
         leftPow *= nums[i];
         output[i] = leftPow;
      }
      for (int i = nums.length - 1; i > 0; i--) {
         output[i] = output[i - 1] * rightPow;
         rightPow *= nums[i];
      }
      output[0] = rightPow;
      return output;
   }
}
