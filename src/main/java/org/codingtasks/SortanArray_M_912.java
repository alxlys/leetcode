package org.codingtasks;

import org.codingtasks.util.Util;

/**
 * https://leetcode.com/problems/sort-an-array/
 *
 * @author olysenko
 */
public class SortanArray_M_912 {

   public static void main(String[] args) {
      SortanArray_M_912 solution = new SortanArray_M_912();
      //Input: nums = [5,2,3,1]
      //Output: [1,2,3,5]
//      int[] res = solution.sortArray(new int[] { 5, 2, 3, 1 });
      int[] res = solution.sortArray(new int[] { 5, 2, 14, 6, 1, 7, 13, 3, 4, 0, 11, 9, 8, 10, 15, 12 });
      Util.printArray(res);

   }

   public int[] sortArray(int[] nums) {
      return mergeSort(nums, 0, nums.length - 1);
   }

   private int[] mergeSort(int[] array, int s, int e) {
      if (s >= e) {
         return array;
      }
      int m = (s + e) / 2;
      mergeSort(array, s, m);
      mergeSort(array, m + 1, e);

      array = merge(array, s, m + 1, e);

      return array;
   }

   private int[] merge(int[] array, int s, int m, int e) {
      int i1 = s;
      int i2 = m;
      int mid = m - 1;
      int i = 0;
      int length = e - s + 1;
      int[] tempArray = new int[length];

      while (i1 <= mid && i2 <= e) {
         if (array[i1] < array[i2]) {
            tempArray[i++] = array[i1++];
         } else {
            tempArray[i++] = array[i2++];
         }
      }
      while (i1 <= mid) {
         tempArray[i++] = array[i1++];
      }
      while (i2 <= e) {
         tempArray[i++] = array[i2++];
      }

      System.arraycopy(tempArray, 0, array, s, length);
      return array;
   }


}
