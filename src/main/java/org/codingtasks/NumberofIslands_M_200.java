package org.codingtasks;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * @author olysenko
 */
public class NumberofIslands_M_200 {

   public static void main(String[] args) {
      NumberofIslands_M_200 solution = new NumberofIslands_M_200();
      //Input: grid = [
      //  ["1","1","1","1","0"],
      //  ["1","1","0","1","0"],
      //  ["1","1","0","0","0"],
      //  ["0","0","0","0","0"]
      //]
      //Output: 1
      char[][] grid =
            new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                  { '0', '0', '0', '0', '0' } };
      System.out.println(solution.numIslands(grid));

      //Input: grid = [
      //  ["1","1","0","0","0"],
      //  ["1","1","0","0","0"],
      //  ["0","0","1","0","0"],
      //  ["0","0","0","1","1"]
      //]
      //Output: 3

      grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
            { '0', '0', '0', '1', '1' } };
      System.out.println(solution.numIslands(grid));
   }

   public int numIslands(char[][] grid) {
      int row = grid.length;
      int col = grid[0].length;
      int islandCount = 0;

      for (int r = 0; r < row; r++) {
         for (int c = 0; c < col; c++) {
            if (grid[r][c] == '1') {
               dfs(grid, r, c);
               islandCount++;
            }
         }
      }
      return islandCount;
   }

   private void dfs(char[][] grid, int row, int col) {
      if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
         return;
      }
      grid[row][col] = '0';
      dfs(grid, row + 1, col);
      dfs(grid, row - 1, col);
      dfs(grid, row, col + 1);
      dfs(grid, row, col - 1);
   }

}
