package org.codingtasks;

/**
 * https://leetcode.com/problems/max-area-of-island/
 *
 * @author olysenko
 */
public class MaxAreaofIsland_M_695 {

   public static void main(String[] args) {
      MaxAreaofIsland_M_695 solution = new MaxAreaofIsland_M_695();
      // Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],
      // [0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],
      // [0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
      //Output: 6
      //Explanation: The answer is not 11, because the island must be connected 4-directionally.
      System.out.println(solution.maxAreaOfIsland(
            new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                  { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                  { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                  { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));
   }

   public int maxAreaOfIsland(int[][] grid) {
      int row = grid.length;
      int col = grid[0].length;
      int maxIslandArea = 0;

      for (int r = 0; r < row; r++) {
         for (int c = 0; c < col; c++) {
            if (grid[r][c] == 1) {
               int area = dfs(grid, r, c);
               if (area > maxIslandArea) {
                  maxIslandArea = area;
               }
            }
         }
      }
      return maxIslandArea;
   }

   private int dfs(int[][] grid, int row, int col) {
      if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
         return 0;
      }
      grid[row][col] = 0;
      int area = 1;
      area += dfs(grid, row + 1, col);
      area += dfs(grid, row - 1, col);
      area += dfs(grid, row, col + 1);
      area += dfs(grid, row, col - 1);
      return area;
   }

}
