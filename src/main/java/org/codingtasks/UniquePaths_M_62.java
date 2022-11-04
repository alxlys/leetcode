package org.codingtasks;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * @author olysenko
 */
public class UniquePaths_M_62 {

   public static void main(String[] args) {

      UniquePaths_M_62 solution = new UniquePaths_M_62();
      //Input: m = 3, n = 7
      //Output: 28
      System.out.println(solution.uniquePaths(3, 7));

      //Input: m = 3, n = 2
      //Output: 3
      System.out.println(solution.uniquePaths(3, 2));

      System.out.println(solution.uniquePaths(1, 2));
   }

   public int uniquePaths(int m, int n) {
      if (m == 1) {
         return 1;
      }
      int[] prevRow = new int[n];
      for (int i = 0; i < n; i++) {
         prevRow[i] = 1;
      }
      int[] currRow = new int[n];
      for (int row = m - 2; row >= 0; row--) {
         currRow[n - 1] = 1;
         for (int col = n - 2; col >= 0; col--) {
            currRow[col] = currRow[col + 1] + prevRow[col];
         }
         prevRow = currRow;
      }
      return currRow[0];
   }
}
