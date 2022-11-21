package org.codingtasks;

import java.util.HashMap;

/**
 * @author olysenko
 */
public class SubarraySumEqualsK_M_560 {

   public static void main(String[] args) {
      SubarraySumEqualsK_M_560 solution = new SubarraySumEqualsK_M_560();
      //Input: nums = [1,1,1], k = 2
      //Output: 2
      System.out.println(solution.subarraySum(new int[] { 1, 1, 1 }, 2));

      //Input: nums = [1,2,3], k = 3
      //Output: 2
      System.out.println(solution.subarraySum(new int[] { 1, 2, 3 }, 3));

      //[1]
      //0
      System.out.println(solution.subarraySum(new int[] { 1 }, 0));

      //[-1,-1,1]
      //0
      System.out.println(solution.subarraySum(new int[] { -1, -1, 1 }, 0));
   }

   public int subarraySum(int[] nums, int k) {
      int count = 0, sum = 0;
      HashMap<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      for (int i = 0; i < nums.length; i++) {
         sum += nums[i];
         if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
         }
         map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
      return count;
   }

}
