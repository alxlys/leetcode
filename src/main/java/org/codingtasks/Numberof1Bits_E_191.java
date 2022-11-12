package org.codingtasks;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * @author olysenko
 */
public class Numberof1Bits_E_191 {

   public static void main(String[] args) {
      Numberof1Bits_E_191 solution = new Numberof1Bits_E_191();
      //Input: n = 00000000000000000000000000001011
      //Output: 3
      System.out.println(solution.hammingWeight(11));

      //Input: n = 00000000000000000000000010000000
      //Output: 1

      //Input: n = 11111111111111111111111111111101
      //Output: 31
      System.out.println(solution.hammingWeight2(-3));

   }

   // you need to treat n as an unsigned value
   public int hammingWeight(int n) {
      int count = 0;
      int mask = 1;
      for (int i = 0; i < 32; i++) {
         if ((n & mask) != 0) {
            count++;
         }
         n >>= 1;
      }
      return count;
   }

   // you need to treat n as an unsigned value
   public int hammingWeight2(int n) {
      int count = 0;
      while (n != 0) {
         n = n & (n - 1);
         count++;
      }
      return count;
   }


}
