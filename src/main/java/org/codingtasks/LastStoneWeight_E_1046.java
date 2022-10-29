package org.codingtasks;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/last-stone-weight/
 *
 * @author olysenko
 */
public class LastStoneWeight_E_1046 {

   public static void main(String[] args) {
      LastStoneWeight_E_1046 solution = new LastStoneWeight_E_1046();
      //Input: stones = [2,7,4,1,8,1]
      //Output: 1
      System.out.println(solution.lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));

      //Input: stones = [1]
      //Output: 1
      System.out.println(solution.lastStoneWeight(new int[] { 1 }));
   }

   public int lastStoneWeight(int[] stones) {
      Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
      for (int stone : stones) {
         heap.add(stone);
      }
      int i = 1;
      int stoneWeight = 0;
      while (!heap.isEmpty()) {
         if (i % 2 == 0) {
            stoneWeight = stoneWeight - heap.poll();
            if (stoneWeight != 0) {
               heap.add(stoneWeight);
            }
         } else {
            stoneWeight = heap.poll();
         }
         i++;
      }
      return stoneWeight;
   }

}
