package org.codingtasks;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * @author olysenko
 */
public class ContainsDuplicate_E_217 {

   public static void main(String[] args) {

      ContainsDuplicate_E_217 solution = new ContainsDuplicate_E_217();
      //Input: nums = [1,2,3,1]
      //Output: true
      System.out.println(solution.containsDuplicate(new int[] { 1, 2, 3, 1 }));

      //Input: nums = [1,2,3,4]
      //Output: false
      System.out.println(solution.containsDuplicate(new int[] { 1, 2, 3, 4 }));

      //Input: nums = [1,1,1,3,3,4,3,2,4,2]
      //Output: true
      System.out.println(solution.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
   }

   public boolean containsDuplicate(int[] nums) {
      Set<Integer> uniqueSet = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
         if (uniqueSet.size() != i) {
            return true;
         }
         uniqueSet.add(nums[i]);
      }
      return uniqueSet.size() != nums.length;
   }

//   public boolean containsDuplicate(int[] nums) {
//      Set<Integer> uniques = new HashSet<>();
//      for (int i = 0; i < nums.length; i++) {
//         if (uniques.contains(nums[i])) {
//            return true;
//         }
//         uniques.add(nums[i]);
//      }
//      return false;
//   }

}
