package org.codingtasks;

/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * @author olysenko
 */
public class SearchInsertPosition_E_35 {

   public static void main(String[] args) {
      SearchInsertPosition_E_35 solution = new SearchInsertPosition_E_35();
      // nums = [1,3,5,6], target = 5
      int nums[] = { 1, 3, 5, 6 };
      System.out.println(solution.searchInsert(nums, 5));
      // nums = [1,3,5,6], target = 2
      int nums1[] = { 1, 3, 5, 6 };
      System.out.println(solution.searchInsert(nums1, 2));
      // nums = [1,3,5,6], target = 7
      int nums2[] = { 1, 3, 5, 6 };
      System.out.println(solution.searchInsert(nums2, 7));

   }

   public int searchInsert(int[] nums, int target) {
      return search(nums, 0, nums.length, target);
   }

   private int search(int[] nums, int start, int end, int target) {
      if (start == end) {
         return start;
      }
      int mid = (start + end) / 2;

      if (target == nums[mid]) {
         return mid;
      } else if (target > nums[mid]) {
         return search(nums, mid + 1, end, target);
      } else {
         return search(nums, 0, mid, target);
      }
   }

}