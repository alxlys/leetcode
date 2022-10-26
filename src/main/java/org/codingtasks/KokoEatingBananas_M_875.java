package org.codingtasks;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 *
 * @author olysenko
 */
public class KokoEatingBananas_M_875 {

   public static void main(String[] args) {
      KokoEatingBananas_M_875 solution = new KokoEatingBananas_M_875();
      //Input: piles = [3,6,7,11], h = 8
      //Output: 4
      System.out.println(solution.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));

      //Input: piles = [30,11,23,4,20], h = 5
      //Output: 30
      System.out.println(solution.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));

      //Input: piles = [30,11,23,4,20], h = 6
      //Output: 23
      System.out.println(solution.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
   }

   public int minEatingSpeed(int[] piles, int h) {
      int left = 0;
      int right = 0;
//      int right = Arrays.stream(piles).max().getAsInt();
      for (int pile : piles) {
         right = Math.max(right, pile);
      }
      int res = right;

      while (left <= right) {
         int k = (left + right) / 2;
         int hours = 0;
         for (int pile : piles) {
            hours += Math.ceil((double) pile / k);
         }
         if (hours <= h) {
            res = Math.min(res, k);
            right = k - 1;
         } else {
            left = k + 1;
         }
      }
      return res;
      // Initalize the left and right boundaries
//      int left = 1, right = 1;
//      for (int pile : piles) {
//         right = Math.max(right, pile);
//      }
//
//      while (left < right) {
//         // Get the middle index between left and right boundary indexes.
//         // hourSpent stands for the total hour Koko spends.
//         int middle = (left + right) / 2;
//         int hourSpent = 0;
//
//         // Iterate over the piles and calculate hourSpent.
//         // We increase the hourSpent by ceil(pile / middle)
//         for (int pile : piles) {
//            hourSpent += Math.ceil((double) pile / middle);
//         }
//
//         // Check if middle is a workable speed, and cut the search space by half.
//         if (hourSpent <= h) {
//            right = middle;
//         } else {
//            left = middle + 1;
//         }
//      }
//
//      // Once the left and right boundaries coincide, we find the target value,
//      // that is, the minimum workable eating speed.
//      return right;
   }

}
