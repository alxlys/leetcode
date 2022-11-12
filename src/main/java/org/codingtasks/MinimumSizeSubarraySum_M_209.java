package org.codingtasks;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * @author olysenko
 */
public class MinimumSizeSubarraySum_M_209 {

   public static void main(String[] args) {
      MinimumSizeSubarraySum_M_209 solution = new MinimumSizeSubarraySum_M_209();
      //Input: target = 7, nums = [2,3,1,2,4,3]
      //Output: 2
      //Explanation: The subarray [4,3] has the minimal length under the problem constraint.
      System.out.println(solution.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));

      //Input: target = 4, nums = [1,4,4]
      //Output: 1
      System.out.println(solution.minSubArrayLen(4, new int[] { 1, 4, 4 }));

      //Input: target = 11, nums = [1,1,1,1,1,1,1,1]
      //Output: 0
      System.out.println(solution.minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
   }

   public int minSubArrayLen(int target, int[] nums) {
      int minLength = Integer.MAX_VALUE;
      int totalSum = 0;
      int left = 0;

      for (int right = 0; right < nums.length; right++) {
         totalSum += nums[right];
         while (totalSum >= target) {
            minLength = Math.min(minLength, right - left + 1);
            totalSum -= nums[left];
            left++;
         }
      }
      return minLength == Integer.MAX_VALUE ? 0 : minLength;
   }

}
