package org.codingtasks;

import org.codingtasks.util.Util;

/**
 * https://leetcode.com/problems/plus-one/
 *
 * @author olysenko
 */
public class PlusOne_E_66 {

   public static void main(String[] args) {
      PlusOne_E_66 solution = new PlusOne_E_66();
      // Input: digits = [1,2,3]
      // Output: [1,2,4]
      Util.printArray(solution.plusOne(new int[] { 1, 2, 3 }));

      // Input: digits = [4,3,2,1]
      // Output: [4,3,2,2]
      Util.printArray(solution.plusOne(new int[] { 4, 3, 2, 1 }));

      // Input: digits = [9]
      // Output: [1,0]
      Util.printArray(solution.plusOne(new int[] { 9 }));

   }

   public int[] plusOne(int[] digits) {
      int i = digits.length - 1;
      for (; i >= 0; i--) {
         int value = digits[i] + 1;
         if (value == 10) {
            digits[i] = 0;
         } else {
            digits[i] = value;
            break;
         }
      }
      if (i == -1) {
         int[] newDigits = new int[digits.length + 1];
         newDigits[0] = 1;
         System.arraycopy(digits, 0, newDigits, 1, digits.length);
         digits = newDigits;
      }
      return digits;
   }

}
