package org.codingtasks;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * @author olysenko
 */
public class ClimbingStairs_E_70 {

   public static void main(String[] args) {

      ClimbingStairs_E_70 solution = new ClimbingStairs_E_70();

      //Input: n = 2
      //Output: 2
      System.out.println(solution.climbStairs1(2));
      System.out.println(solution.climbStairs2(2));
      System.out.println(solution.climbStairs3(2));

      //Input: n = 3
      //Output: 3
      System.out.println(solution.climbStairs1(3));
      System.out.println(solution.climbStairs2(3));
      System.out.println(solution.climbStairs3(3));

   }

   public int climbStairs1(int n) {
      int a = 1;
      int b = 1;
      int c;

      for (int i = 0; i < n - 1; i++) {
         c = a + b;
         a = b;
         b = c;
      }
      return b;
   }

   public int climbStairs2(int n) {
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;

      for (int i = 2; i < n + 1; i++) {
         dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
   }

   public int climbStairs3(int n) {
      int[] memo = new int[n + 1];
      Arrays.fill(memo, -1);

      return climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
   }

   private int climbStairs(int n, int[] memo) {
      if (n < 0)
         return 0;
      if (n == 0 || n == 1) {
         memo[n] = 1;
         return memo[n];
      }
      if (memo[n] != -1)
         return memo[n];

      memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
      return memo[n];
   }
}
