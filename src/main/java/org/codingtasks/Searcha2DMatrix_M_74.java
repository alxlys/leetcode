package org.codingtasks;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * @author olysenko
 */
public class Searcha2DMatrix_M_74 {

   public static void main(String[] args) {
      Searcha2DMatrix_M_74 solution = new Searcha2DMatrix_M_74();
      //Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
      //Output: true
      System.out
            .println(solution.searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 3));

      //Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
      //Output: false
      System.out
            .println(solution.searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 13));

   }

   public boolean searchMatrix(int[][] matrix, int target) {
      int rows = matrix.length;
      int cols = matrix[0].length;

      int top = 0;
      int bot = rows - 1;
      int row = -1;
      while (top <= bot) {
         row = (top + bot) / 2;
         if (target > matrix[row][cols - 1]) {
            top = row + 1;
         } else if (target < matrix[row][0]) {
            bot = row - 1;
         } else {
            break;
         }
      }

      if (top > bot) {
         return false;
      }

      int left = 0;
      int right = cols - 1;
      while (left <= right) {
         int mid = (left + right) / 2;
         if (target > matrix[row][mid]) {
            left = mid + 1;
         } else if (target < matrix[row][mid]) {
            right = mid - 1;
         } else {
            return true;
         }
      }
      return false;
   }
}
