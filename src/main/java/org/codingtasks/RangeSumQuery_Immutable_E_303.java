package org.codingtasks;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 * @author olysenko
 */
public class RangeSumQuery_Immutable_E_303 {

   public static void main(String[] args) {
      //Input
      //["NumArray", "sumRange", "sumRange", "sumRange"]
      //[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
      //Output
      //[null, 1, -1, -3]
      //
      //Explanation
      NumArray numArray = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
      System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
      System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
      System.out.println(numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
   }

   static class NumArray {

      private final int[] prefixSum;

      public NumArray(int[] nums) {
         this.prefixSum = new int[nums.length];
         int sum = 0;
         for (int i = 0; i< prefixSum.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
         }
      }

      public int sumRange(int left, int right) {
         int leftIdx = left - 1;
         return prefixSum[right] - (leftIdx >= 0 ? prefixSum[leftIdx] : 0);
      }
   }


}
