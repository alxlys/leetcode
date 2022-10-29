package org.codingtasks;

import org.codingtasks.util.Util;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * @author olysenko
 */
public class KClosestPointstoOrigin_M_973 {

   public static void main(String[] args) {
      KClosestPointstoOrigin_M_973 solution = new KClosestPointstoOrigin_M_973();
      //Input: points = [[1,3],[-2,2]], k = 1
      //Output: [[-2,2]]
      int[][] result = solution.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1);
      Util.printArray(result);

      //Input: points = [[3,3],[5,-1],[-2,4]], k = 2
      //Output: [[3,3],[-2,4]]
      result = solution.kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2);
      Util.printArray(result);
   }

   private static class PointData implements Comparable<PointData> {

      double distance;
      int[] point;

      public PointData(double distance, int[] point) {
         this.distance = distance;
         this.point = point;
      }

      @Override
      public int compareTo(PointData o) {
         return Double.compare(this.distance, o.distance);
      }
   }

   public int[][] kClosest(int[][] points, int k) {
      Queue<PointData> heap = new PriorityQueue<>();
      for (int[] point : points) {
         heap.add(new PointData(point[0] * point[0] + point[1] * point[1], point));
      }
      int[][] res = new int[k][2];
      for (int i = 0; i < k; i++) {
         res[i] = heap.poll().point;
      }
      return res;
   }

}
