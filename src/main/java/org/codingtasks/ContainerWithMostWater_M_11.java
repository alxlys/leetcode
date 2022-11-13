package org.codingtasks;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * @author olysenko
 */
public class ContainerWithMostWater_M_11 {

   public static void main(String[] args) {
      ContainerWithMostWater_M_11 solution = new ContainerWithMostWater_M_11();
      //Input: height = [1,8,6,2,5,4,8,3,7]
      //Output: 49
      //Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
      // In this case, the max area of water (blue section) the container can contain is 49.
      System.out.println(solution.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));

      //Input: height = [1,1]
      //Output: 1
      System.out.println(solution.maxArea(new int[] { 1, 1 }));
   }

   public int maxArea(int[] height) {
      int l = 0;
      int r = height.length - 1;
      int maxArea = 0;
      while (r > l) {
         maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
         if (height[l] < height[r]) {
            l++;
         } else {
            r--;
         }
      }
      return maxArea;
   }


}
