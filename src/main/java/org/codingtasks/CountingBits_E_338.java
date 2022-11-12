package org.codingtasks;

import org.codingtasks.util.Util;

/**
 * https://leetcode.com/problems/counting-bits/
 *
 * @author olysenko
 */
public class CountingBits_E_338 {

   public static void main(String[] args) {
      CountingBits_E_338 solution = new CountingBits_E_338();
      //Input: n = 2
      //Output: [0,1,1]
      Util.printArray(solution.countBits(2));

      //Input: n = 5
      //Output: [0,1,1,2,1,2]
      Util.printArray(solution.countBits(5));

   }

   //O(n)
   public int[] countBits(int n) {
      int[] dp = new int[n + 1];
      int offset = 1;

      for (int i = 1; i < n + 1; i++) {
         if (offset * 2 == i) {
            offset = i;
         }
         dp[i] = 1 + dp[i - offset];
      }
      return dp;
   }

   //O(n*log n)
   //   public int[] countBits(int n) {
   //      int[] ans = new int[n + 1];
   //
   //      for (int i = 0; i <= n; i++) {
   //         ans[i] = count(i);
   //      }
   //      return ans;
   //   }

   private int count(int x) {
      int count = 0;
      while (x != 0) {
         x &= x - 1;
         count++;
      }
      return count;
   }


}
