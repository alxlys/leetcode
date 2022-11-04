package org.codingtasks;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * @author olysenko
 */
public class UniquePathsII_M_63 {

   public static void main(String[] args) {
      UniquePathsII_M_63 solution = new UniquePathsII_M_63();
      //Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
      //Output: 2
      System.out.println(solution.uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));

      //Input: obstacleGrid = [[0,1],[0,0]]
      //Output: 1
      System.out.println(solution.uniquePathsWithObstacles(new int[][] { { 0, 1 }, { 0, 0 } }));
   }

   public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int ROWS = obstacleGrid.length - 1;
      int COLS = obstacleGrid[0].length - 1;

      if (obstacleGrid[0][0] == 1 || obstacleGrid[ROWS][COLS] == 1) {
         return 0;
      }

      boolean obstacle = false;
      for (int col = COLS; col >= 0; col--) {
         if (obstacleGrid[ROWS][col] == 1) {
            obstacleGrid[ROWS][col] = -1;
            obstacle = true;
         }
         if (obstacleGrid[ROWS][col] == 0 && !obstacle) {
            obstacleGrid[ROWS][col] = 1;
         }
      }

      obstacle = false;
      for (int row = ROWS - 1; row >= 0; row--) {
         if (obstacleGrid[row][COLS] == 1) {
            obstacleGrid[row][COLS] = -1;
            obstacle = true;
         }
         if (obstacleGrid[row][COLS] == 0 && !obstacle) {
            obstacleGrid[row][COLS] = 1;
         }

         for (int col = COLS - 1; col >= 0; col--) {
            if (obstacleGrid[row][col] == 1) {
               obstacleGrid[row][col] = -1;
            } else {
               obstacleGrid[row][col] = (obstacleGrid[row][col + 1] == -1 ? 0 : obstacleGrid[row][col + 1])
                     + (obstacleGrid[row + 1][col] == -1 ? 0 : obstacleGrid[row + 1][col]);
            }
         }
      }
      return obstacleGrid[0][0];
   }

}
