package org.codingtasks;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * @author olysenko
 */
public class TrappingRainWater_H_42 {

   public static void main(String[] args) {
      TrappingRainWater_H_42 solution = new TrappingRainWater_H_42();
      //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
      //Output: 6
      //Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
      // In this case, 6 units of rain water (blue section) are being trapped.
      System.out.println(solution.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));

      //Input: height = [4,2,0,3,2,5]
      //Output: 9
      System.out.println(solution.trap(new int[] { 4, 2, 0, 3, 2, 5 }));
   }

   //DP solution with O(n) cpu and O(n) space
//   public int trap(int[] height) {
//      if (height.length < 2) {
//         return 0;
//      }
//      int[] leftMax= new int[height.length];
//      int highestLeftMax = 0;
//      for (int i = 0; i < leftMax.length; i++) {
//         if (height[i] > highestLeftMax) {
//            highestLeftMax = height[i];
//         }
//         leftMax[i] = highestLeftMax;
//      }
//      int[] rightMax = new int[height.length];
//      int highestRightMax = 0;
//      for (int i = rightMax.length - 1; i >=0; i--) {
//         if (height[i] > highestRightMax) {
//            highestRightMax = height[i];
//         }
//         rightMax[i] = highestRightMax;
//      }
//      int totalTrapped = 0;
//      for (int i = 0; i < height.length; i++) {
//         int trapped = Math.min(leftMax[i], rightMax[i]) - height[i];
//         totalTrapped += Math.max(trapped, 0);
//      }
//      return totalTrapped;
//   }

   // 2 pointers O(n) with O(1) space solution
   public int trap(int[] height) {
      int l = 0;
      int r = height.length - 1;
      int maxLeft = height[l];
      int maxRight = height[r];
      int totalTrapped= 0;
      while (l < r) {
         if (maxLeft < maxRight) {
            l++;
            maxLeft = Math.max(maxLeft, height[l]);
            totalTrapped += maxLeft - height[l];
         } else {
            r--;
            maxRight = Math.max(maxRight, height[r]);
            totalTrapped += maxRight - height[r];
         }
      }
      return totalTrapped;
   }

}
