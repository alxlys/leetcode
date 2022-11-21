package org.codingtasks;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/find-pivot-index/
 *
 * @author olysenko
 */
public class FindPivotIndex_E_724 {

   public static void main(String[] args) {
      FindPivotIndex_E_724 solution = new FindPivotIndex_E_724();
      //Input: nums = [1,7,3,6,5,6]
      //Output: 3
      //Explanation:
      //The pivot index is 3.
      //Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
      //Right sum = nums[4] + nums[5] = 5 + 6 = 11
      System.out.println(solution.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));

      //Input: nums = [1,2,3]
      //Output: -1
      //Explanation:
      //There is no index that satisfies the conditions in the problem statement.
      System.out.println(solution.pivotIndex(new int[] { 1, 2, 3 }));

      //Input: nums = [2,1,-1]
      //Output: 0
      //Explanation:
      //The pivot index is 0.
      //Left sum = 0 (no elements to the left of index 0)
      //Right sum = nums[1] + nums[2] = 1 + -1 = 0
      System.out.println(solution.pivotIndex(new int[] { 2, 1, -1 }));
   }

   public int pivotIndex(int[] nums) {
      int totalSum = IntStream.of(nums).sum();
      int leftSum = 0;

      for (int i = 0; i < nums.length; i++) {
         if (leftSum == totalSum - nums[i] - leftSum) {
            return i;
         }
         leftSum += nums[i];
      }
      return -1;
   }

}
