package org.codingtasks;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 *
 * @author olysenko
 */
public class ShortestPathinBinaryMatrix_M_1091 {

   public static void main(String[] args) {
      ShortestPathinBinaryMatrix_M_1091 solution = new ShortestPathinBinaryMatrix_M_1091();
      //Input: grid = [[0,1],[1,0]]
      //Output: 2
      System.out.println(solution.shortestPathBinaryMatrix(new int[][] { { 0, 1 }, { 1, 0 } }));

      //Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
      //Output: 4
      System.out.println(solution.shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } }));

      //Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
      //Output: -1
      System.out.println(solution.shortestPathBinaryMatrix(new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } }));

      //[[0,0,0],[1,1,0],[1,1,1]]
      System.out.println(solution.shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } }));
   }

   static class Node {
      int row;
      int col;

      public Node(int row, int col) {
         this.row = row;
         this.col = col;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o)
            return true;
         if (o == null || getClass() != o.getClass())
            return false;
         Node node = (Node) o;
         return row == node.row && col == node.col;
      }

      @Override
      public int hashCode() {
         return Objects.hash(row, col);
      }
   }

   public int shortestPathBinaryMatrix(int[][] grid) {
      int rows = grid.length;
      int cols = grid[0].length;
      if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
         return -1;
      }
      Queue<Node> queue = new LinkedList<>();
      Set<Node> visited = new HashSet<>();
      Node first = new Node(0, 0);
      queue.add(first);
      visited.add(first);

      int pathLength = 1;
      while (!queue.isEmpty()) {
         int queueLength = queue.size();
         for (int i = 0; i < queueLength; i++) {
            Node node = queue.poll();

            if (node.row == rows - 1 && node.col == cols - 1) {
               return pathLength;
            }

            for (int r = -1; r <= 1; r++) {
               for (int c = -1; c <= 1; c++) {
                  Node newNode;
                  if (node.row + r < 0 || node.col + c < 0 || node.row + r >= rows || node.col + c >= cols ||
                        grid[node.row + r][node.col + c] == 1 ||
                        visited.contains((newNode = new Node(node.row + r, node.col + c)))) {
                     continue;
                  }
                  queue.add(newNode);
                  visited.add(newNode);
               }
            }
         }
         pathLength++;
      }
      return -1;
   }


}
