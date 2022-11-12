package org.codingtasks;

/**
 * https://leetcode.com/problems/reverse-bits/
 *
 * @author olysenko
 */
public class ReverseBits_E_190 {

   public static void main(String[] args) {

      ReverseBits_E_190 solution = new ReverseBits_E_190();
      System.out.println(solution.reverseBits(555));

   }

   // you need treat n as an unsigned value
   public int reverseBits(int n) {
      int ans = 0;

      for (int i = 0; i < 32; i++) {
         ans <<= 1;
         ans |= (n & 1);
         n >>= 1;
      }
      return ans;
   }

}
