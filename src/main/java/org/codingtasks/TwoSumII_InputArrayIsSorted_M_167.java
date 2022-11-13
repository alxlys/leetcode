package org.codingtasks;

import org.codingtasks.util.Util;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author olysenko
 */
public class TwoSumII_InputArrayIsSorted_M_167 {

   public static void main(String[] args) {
      TwoSumII_InputArrayIsSorted_M_167 solution = new TwoSumII_InputArrayIsSorted_M_167();
      //Input: numbers = [2,7,11,15], target = 9
      //Output: [1,2]
      //Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
      Util.printArray(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));


      //Input: numbers = [2,3,4], target = 6
      //Output: [1,3]
      //Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
      Util.printArray(solution.twoSum(new int[] { 2, 3, 4 }, 6));

      //Input: numbers = [-1,0], target = -1
      //Output: [1,2]
      //Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
      Util.printArray(solution.twoSum(new int[] { -1, 0 }, -1));
   }

   public int[] twoSum(int[] numbers, int target) {
      int left = 0;
      int right = numbers.length - 1;

      while (true) {
         if (numbers[left] + numbers[right] < target) {
            left++;
         } else if (numbers[left] + numbers[right] > target) {
            right--;
         } else {
            break;
         }
      }
      return new int[] { left + 1, right + 1 };
   }

}
