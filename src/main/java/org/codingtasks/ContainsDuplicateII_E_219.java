package org.codingtasks;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 *
 * @author olysenko
 */
public class ContainsDuplicateII_E_219 {

   public static void main(String[] args) {
      ContainsDuplicateII_E_219 solution = new ContainsDuplicateII_E_219();
      //Input: nums = [1,2,3,1], k = 3
      //Output: true
      System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));

      //Input: nums = [1,0,1,1], k = 1
      //Output: true
      System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));

      //Input: nums = [1,2,3,1,2,3], k = 2
      //Output: false
      System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
   }

   public boolean containsNearbyDuplicate(int[] nums, int k) {
      Map<Integer, Integer> numIndexMap = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         int num = nums[i];
         if (numIndexMap.containsKey(num) && i - numIndexMap.get(num) <= k) {
            return true;
         }
         numIndexMap.put(num, i);
      }
      return false;
   }

}
