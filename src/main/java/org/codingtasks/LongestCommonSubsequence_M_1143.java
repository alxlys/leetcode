package org.codingtasks;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * @author olysenko
 */
public class LongestCommonSubsequence_M_1143 {

   public static void main(String[] args) {
      LongestCommonSubsequence_M_1143 solution = new LongestCommonSubsequence_M_1143();
      //Input: text1 = "abcde", text2 = "ace"
      //Output: 3
      System.out.println(solution.longestCommonSubsequence("abcde", "ace"));

      //Input: text1 = "abc", text2 = "abc"
      //Output: 3
      System.out.println(solution.longestCommonSubsequence("abc", "abc"));

      //Input: text1 = "abc", text2 = "def"
      //Output: 0
      System.out.println(solution.longestCommonSubsequence("abc", "def"));
   }


   public int longestCommonSubsequence(String text1, String text2) {

      int[][] grid = new int[text1.length() + 1][text2.length() + 1];
      char[] text1Chars = text1.toCharArray();
      char[] text2Chars = text2.toCharArray();

      for (int row = grid.length - 2; row >= 0; row--) {
         for (int col = grid[0].length - 2; col >= 0; col--) {
            if (text1Chars[row] == text2Chars[col]) {
               grid[row][col] = 1 + grid[row + 1][col + 1];
            } else {
               grid[row][col] = Math.max(grid[row][col + 1], grid[row + 1][col]);
            }
         }
      }
      return grid[0][0];

   }

}
