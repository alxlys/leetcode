package org.codingtasks;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @author olysenko
 */
public class RemoveDuplicatesfromSortedArrayII_M_80 {

   public static void main(String[] args) {
      RemoveDuplicatesfromSortedArrayII_M_80 solution = new RemoveDuplicatesfromSortedArrayII_M_80();
      //Input: nums = [1,1,1,2,2,3]
      //Output: 5, nums = [1,1,2,2,3,_]
      //Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
      //It does not matter what you leave beyond the returned k (hence they are underscores).
      System.out.println(solution.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));

      //Input: nums = [0,0,1,1,1,1,2,3,3]
      //Output: 7, nums = [0,0,1,1,2,3,3,_,_]
      //Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
      //It does not matter what you leave beyond the returned k (hence they are underscores).
      System.out.println(solution.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
   }

   public int removeDuplicates(int[] nums) {
      if (nums.length <= 2) {
         return nums.length;
      }
      int left = 0;
      int dup = 1;
      for (int right = 1; right < nums.length; right++) {
         if (nums[left] == nums[right]) {
            if (dup < 2) {
               nums[++left] = nums[right];
            }
            dup++;
         } else {
            nums[++left] = nums[right];
            dup = 1;
         }
      }
      return left + 1;
   }

}
