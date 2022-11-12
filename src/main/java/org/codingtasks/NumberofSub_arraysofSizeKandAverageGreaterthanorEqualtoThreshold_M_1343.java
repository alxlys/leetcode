package org.codingtasks;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 *
 * @author olysenko
 */
public class NumberofSub_arraysofSizeKandAverageGreaterthanorEqualtoThreshold_M_1343 {

   public static void main(String[] args) {
      NumberofSub_arraysofSizeKandAverageGreaterthanorEqualtoThreshold_M_1343 solution =
            new NumberofSub_arraysofSizeKandAverageGreaterthanorEqualtoThreshold_M_1343();
      //Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
      //Output: 3
      //Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
      System.out.println(solution.numOfSubarrays(new int[] { 2, 2, 2, 2, 5, 5, 5, 8 }, 3, 4));


      //Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
      //Output: 6
      //Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
      System.out.println(solution.numOfSubarrays(new int[] { 11, 13, 17, 23, 29, 31, 7, 5, 2, 3 }, 3, 5));
   }

   public int numOfSubarrays(int[] arr, int k, int threshold) {
      int left = 0;
      int countSubArrays = 0;
      int sum = 0;

      for (int right = 0; right < arr.length; right++) {
         if (right - left + 1 > k) {
            sum -= arr[left];
            left++;
         }
         sum += arr[right];
         if (right >= k - 1 && sum / k >= threshold) {
            countSubArrays++;
         }
      }
      return countSubArrays;


      //3 ms solution
//      int cnt = 0;
//      int start = 0;
//      int sum = 0;
//
//      for(int end = 0; end < arr.length; end++){
//         sum += arr[end];
//         if(end - start + 1 >= k){
//            if(sum/k >= threshold){
//               cnt++;
//            }
//            sum -= arr[start];
//            start++;
//
//         }
//      }
//      return cnt;

   }
}
