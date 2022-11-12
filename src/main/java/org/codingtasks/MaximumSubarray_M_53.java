package org.codingtasks;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * @author olysenko
 */
public class MaximumSubarray_M_53 {

   public static void main(String[] args) {
      MaximumSubarray_M_53 solution = new MaximumSubarray_M_53();
      //Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
      //Output: 6
      System.out.println(solution.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));

      //Input: nums = [1]
      //Output: 1
      System.out.println(solution.maxSubArray(new int[] { 1 }));

      //Input: nums = [5,4,-1,7,8]
      //Output: 23
      System.out.println(solution.maxSubArray(new int[] { 5, 4, -1, 7, 8 }));

   }

   public int maxSubArray(int[] nums) {
      int maxSum = nums[0];
      int curSum = 0;

      for (int num : nums) {
         curSum = num + Math.max(curSum, 0);
         maxSum = Math.max(curSum, maxSum);
      }
      return maxSum;
   }

}
