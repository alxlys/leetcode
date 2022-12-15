package org.codingtasks;

import org.codingtasks.util.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/redundant-connection/
 *
 * @author olysenko
 */
public class RedundantConnection_M_684 {

   public static void main(String[] args) {
      RedundantConnection_M_684 solution = new RedundantConnection_M_684();
      //Input: edges = [[1,2],[1,3],[2,3]]
      //Output: [2,3]
      Util.printArray(solution.findRedundantConnection(new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } }));

      //Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
      //Output: [1,4]
      Util.printArray(
            solution.findRedundantConnection(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } }));

   }

   public int[] findRedundantConnection(int[][] edges) {
      Map<Integer, Integer> parentMap = new HashMap<>();
      Map<Integer, Integer> rankMap = new HashMap<>();
      for (int i = 1; i < edges.length + 1; i++) {
         parentMap.put(i, i);
         rankMap.put(i, 0);
      }
      for (int[] edge : edges) {
         if (!union(parentMap, rankMap, edge[0], edge[1])) {
            return edge;
         }
      }
      return new int[0];
   }

   private boolean union(Map<Integer, Integer> parentMap, Map<Integer, Integer> rankMap, Integer node1, Integer node2) {
      Integer parent1 = find(parentMap, node1);
      Integer parent2 = find(parentMap, node2);
      if (parent1.equals(parent2)) {
         return false;
      }
      Integer rank1 = rankMap.get(parent1);
      Integer rank2 = rankMap.get(parent2);

      if (rank1 > rank2) {
         parentMap.put(parent2, parent1);
      } else if (rank1 < rank2) {
         parentMap.put(parent1, parent2);
      } else {
         parentMap.put(parent1, parent2);
         rankMap.put(parent2, rankMap.get(parent2) + 1);
      }
      return true;
   }

   private Integer find(Map<Integer, Integer> parentMap, Integer node) {
      Integer parent = parentMap.get(node);
      while (!parent.equals(parentMap.get(parent))) {
         parent = parentMap.get(parentMap.get(parent));
      }
      return parent;
   }

}
