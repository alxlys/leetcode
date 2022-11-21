package org.codingtasks;

/**
 * @author olysenko
 */
public class RangeSumQuery2D_Immutable_M_304 {

   public static void main(String[] args) {
      //["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
      //[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
      //Output
      //[null, 8, 11, 12]
      //
      //Explanation
      NumMatrix numMatrix = new NumMatrix(
            new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
                  { 1, 0, 3, 0, 5 } });
      System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
      System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
      System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)

   }

   static class NumMatrix {

      private final int[][] sumMatrix;

      public NumMatrix(int[][] matrix) {
         this.sumMatrix = new int[matrix.length][matrix[0].length];
         for (int r = 0; r < matrix.length; r++) {
            int prefix = 0;
            for (int c = 0; c < matrix[0].length; c++) {
               prefix += matrix[r][c];
               sumMatrix[r][c] = prefix + (r > 0 ? sumMatrix[r - 1][c] : 0);
            }
         }
      }

      public int sumRegion(int row1, int col1, int row2, int col2) {
         int bottomRightSum = sumMatrix[row2][col2];
         int above = row1 > 0 ? sumMatrix[row1 - 1][col2] : 0;
         int left = col1 > 0 ? sumMatrix[row2][col1 - 1] : 0;
         int topLeft = row1 > 0 && col1 > 0 ? sumMatrix[row1 - 1][col1 - 1] : 0;
         return bottomRightSum - above - left + topLeft;
      }

      // One liner
//      public int sumRegion(int row1, int col1, int row2, int col2) {
//         return sumMatrix[row2][col2] - (row1 > 0 ? sumMatrix[row1 - 1][col2] : 0) -
//               (col1 > 0 ? sumMatrix[row2][col1 - 1] : 0) + (row1 > 0 && col1 > 0 ? sumMatrix[row1 - 1][col1 - 1] : 0);
//      }


   }


}
