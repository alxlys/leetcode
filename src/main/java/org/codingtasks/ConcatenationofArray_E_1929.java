package org.codingtasks;

import org.codingtasks.util.Util;

/**
 * https://leetcode.com/problems/concatenation-of-array/
 *
 * @author olysenko
 */
public class ConcatenationofArray_E_1929 {

   public static void main(String[] args) {
      ConcatenationofArray_E_1929 solution = new ConcatenationofArray_E_1929();
      // Input: nums = [1,2,1]
      // Output: [1,2,1,1,2,1]
      int[] nums = { 1, 2, 1 };
      Util.printArray(solution.getConcatenation(nums));

      // Input: nums = [1,3,2,1]
      // Output: [1,3,2,1,1,3,2,1]
      nums = new int[] { 1, 3, 2, 1 };
      Util.printArray(solution.getConcatenation(nums));

   }

   public int[] getConcatenation(int[] nums) {
      int[] res = new int[nums.length * 2];
      System.arraycopy(nums, 0, res, 0, nums.length);
      System.arraycopy(nums, 0, res, nums.length, nums.length);
      return res;
   }

}
