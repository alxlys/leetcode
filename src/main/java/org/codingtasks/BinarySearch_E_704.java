package org.codingtasks;

/**
 * https://leetcode.com/problems/binary-search/
 *
 * @author olysenko
 */
public class BinarySearch_E_704 {

   public static void main(String[] args) {
      BinarySearch_E_704 solution = new BinarySearch_E_704();
      //Input: nums = [-1,0,3,5,9,12], target = 9
      //Output: 4
      System.out.println(solution.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));

      //Input: nums = [-1,0,3,5,9,12], target = 2
      //Output: -1
      System.out.println(solution.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
   }

   public int search(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;
      while (l <= r) {
         int m = (l + r) / 2;
         if (target < nums[m]) {
            r = m - 1;
         } else if (target > nums[m]) {
            l = m + 1;
         } else {
            return m;
         }
      }
      return -1;
   }

}
