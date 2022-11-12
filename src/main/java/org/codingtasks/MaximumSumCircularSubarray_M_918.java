package org.codingtasks;

/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 *
 * @author olysenko
 */
public class MaximumSumCircularSubarray_M_918 {

   public static void main(String[] args) {
      MaximumSumCircularSubarray_M_918 solution = new MaximumSumCircularSubarray_M_918();
      //Input: nums = [1,-2,3,-2]
      //Output: 3
      System.out.println(solution.maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));

      //Input: nums = [5,-3,5]
      //Output: 10
      System.out.println(solution.maxSubarraySumCircular(new int[] { 5, -3, 5 }));

      //Input: nums = [-3,-2,-3]
      //Output: -2
      System.out.println(solution.maxSubarraySumCircular(new int[] { -3, -2, -3 }));
   }

   public int maxSubarraySumCircular(int[] nums) {
      // Corner Case
      if (nums.length == 1) {
         return nums[0];
      }
      // Initialize every variable with first value of
      // array.
      int curr_max = nums[0], max_so_far = nums[0], curr_min = nums[0], min_so_far = nums[0];
      // Initialize sum variable which store total sum of
      // the array.
      int sum = nums[0];
      // Concept of Kadane's Algorithm
      for (int i = 1; i < nums.length; i++) {
         sum += nums[i];
         // Kadane's Algorithm to find Maximum subarray
         // sum.
         curr_max = Math.max(curr_max + nums[i], nums[i]);
         max_so_far = Math.max(max_so_far, curr_max);

         // Kadane's Algorithm to find Minimum subarray
         // sum.
         curr_min = Math.min(curr_min + nums[i], nums[i]);
         min_so_far = Math.min(min_so_far, curr_min);
      }
      if (min_so_far == sum) {
         return max_so_far;
      }
      // returning the maximum value
      return Math.max(max_so_far, sum - min_so_far);
   }


}
