package org.codingtasks;

import org.codingtasks.util.Util;

/**
 * https://leetcode.com/problems/sort-colors/
 *
 * @author olysenko
 */
public class SortColors_M_75 {

   public static void main(String[] args) {
      SortColors_M_75 solution = new SortColors_M_75();
      //Input: nums = [2,0,2,1,1,0]
      //Output: [0,0,1,1,2,2]
      int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
      solution.sortColors(nums);
      Util.printArray(nums);

      //Input: nums = [2,0,1]
      //Output: [0,1,2]
      nums = new int[] { 2, 0, 1 };
      solution.sortColors(nums);
      Util.printArray(nums);
   }

   public void sortColors(int[] nums) {
      int l = 0;
      int r = nums.length - 1;
      int i = 0;

      while (i <= r) {
         if (nums[i] == 0) {
            swap(nums, i, l);
            l++;
            i++;
         } else if (nums[i] == 2) {
            swap(nums, i, r);
            r--;
         } else {
            i++;
         }
      }
   }

   private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }

}
