package org.codingtasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/rotting-oranges/
 *
 * @author olysenko
 */
public class RottingOranges_M_994 {

   public static void main(String[] args) {
      RottingOranges_M_994 solution = new RottingOranges_M_994();
      //Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
      //Output: 4
      System.out.println(solution.orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));

      //Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
      //Output: -1
      System.out.println(solution.orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));

      //Input: grid = [[0,2]]
      //Output: 0
      System.out.println(solution.orangesRotting(new int[][] { { 0, 2 } }));

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

   public int orangesRotting(int[][] grid) {
      Queue<Node> queue = new LinkedList<>();
      Set<Node> visited = new HashSet<>();

      for (int r = 0; r < grid.length; r++) {
         for (int c = 0; c < grid[r].length; c++) {
            if (grid[r][c] == 2) {
               Node node = new Node(r, c);
               queue.add(node);
               visited.add(node);
            }
         }
      }

      int mins = bfs(grid, queue, visited);

      for (int r = 0; r < grid.length; r++) {
         for (int c = 0; c < grid[r].length; c++) {
            if (grid[r][c] == 1) {
               Node node = new Node(r, c);
               if (!visited.contains(node)) {
                  return -1;
               }
            }
         }
      }
      return mins;
   }

   private int bfs(int[][] grid, Queue<Node> queue, Set<Node> visited) {
      int rows = grid.length;
      int cols = grid[0].length;

      int mins = 0;
      while (!queue.isEmpty()) {
         int queueLength = queue.size();
         boolean increment = false;
         for (int i = 0; i < queueLength; i++) {
            Node node = queue.poll();

            if (grid[node.row][node.col] == 1) {
               increment = true;
            }

            for (Node neighbour : Arrays.asList(new Node(node.row - 1, node.col), new Node(node.row, node.col - 1),
                  new Node(node.row + 1, node.col), new Node(node.row, node.col + 1))) {
               if (neighbour.row < 0 || neighbour.col < 0 || neighbour.row >= rows || neighbour.col >= cols ||
                     grid[neighbour.row][neighbour.col] == 0 || visited.contains(neighbour)) {
                  continue;
               }
               queue.add(neighbour);
               visited.add(neighbour);
            }
         }
         if (increment) {
            mins++;
         }
      }
      return mins;
   }

}
