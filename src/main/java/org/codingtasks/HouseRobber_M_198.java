package org.codingtasks;

/**
 * https://leetcode.com/problems/house-robber/
 *
 * @author olysenko
 */
public class HouseRobber_M_198 {


   public static void main(String[] args) {

      HouseRobber_M_198 solution = new HouseRobber_M_198();
      //Input: nums = [1,2,3,1]
      //Output: 4
      System.out.println(solution.rob(new int[] { 1, 2, 3, 1 }));

      //Input: nums = [2,7,9,3,1]
      //Output: 12
      System.out.println(solution.rob(new int[] { 2, 7, 9, 3, 1 }));
   }

   //   public int rob(int[] nums) {
   //      if (nums == null || nums.length == 0)
   //         return 0;
   //      if (nums.length == 1)
   //         return nums[0];
   //      if (nums.length == 2)
   //         return Math.max(nums[0], nums[1]);
   //
   //      int[] dp = new int[nums.length];
   //      dp[0] = nums[0];
   //      dp[1] = Math.max(nums[0], nums[1]);
   //
   //      for (int i = 2; i < nums.length; i++) {
   //         dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
   //      }
   //      return dp[nums.length - 1];
   //   }

   public int rob(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }
      if (nums.length == 1) {
         return nums[0];
      }
      if (nums.length == 2) {
         return Math.max(nums[0], nums[1]);
      }

      int robWithOutIncludingLastHouse = 0, robWithIncludingLastHouse = 0;

      for (int n : nums) {
         int temp = Math.max(robWithOutIncludingLastHouse + n, robWithIncludingLastHouse);
         robWithOutIncludingLastHouse = robWithIncludingLastHouse;
         robWithIncludingLastHouse = temp;
      }
      return robWithIncludingLastHouse;
   }

}
