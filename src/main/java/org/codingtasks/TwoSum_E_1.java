package org.codingtasks;

import org.codingtasks.util.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * @author olysenko
 */
public class TwoSum_E_1 {

   public static void main(String[] args) {
      TwoSum_E_1 solution = new TwoSum_E_1();
      //Input: nums = [2,7,11,15], target = 9
      //Output: [0,1]
      Util.printArray(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));

      //Input: nums = [3,2,4], target = 6
      //Output: [1,2]
      Util.printArray(solution.twoSum(new int[] { 3, 2, 4 }, 6));

      //Input: nums = [3,3], target = 6
      //Output: [0,1]
      Util.printArray(solution.twoSum(new int[] { 3, 3 }, 6));

   }

   public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> diffMap = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         int diff = target - nums[i];
         if (diffMap.containsKey(diff)) {
            return new int[] { diffMap.get(diff), i };
         }
         diffMap.put(nums[i], i);
      }
      return null;
   }
}
