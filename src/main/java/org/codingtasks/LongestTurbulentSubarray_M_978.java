package org.codingtasks;

/**
 * https://leetcode.com/problems/longest-turbulent-subarray/
 *
 * @author olysenko
 */
public class LongestTurbulentSubarray_M_978 {

   public static void main(String[] args) {
      LongestTurbulentSubarray_M_978 solution = new LongestTurbulentSubarray_M_978();
      //Input: arr = [9,4,2,10,7,8,8,1,9]
      //Output: 5
      //Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
      System.out.println(solution.maxTurbulenceSize(new int[] { 9, 4, 2, 10, 7, 8, 8, 1, 9 }));

      //Input: arr = [4,8,12,16]
      //Output: 2
      System.out.println(solution.maxTurbulenceSize(new int[] { 4, 8, 12, 16 }));


      //Input: arr = [100]
      //Output: 1
      System.out.println(solution.maxTurbulenceSize(new int[] { 1 }));

      System.out.println(solution.maxTurbulenceSize(new int[] { 9, 9 }));

      System.out.println(solution.maxTurbulenceSize(new int[] { 4, 5 }));

      System.out.println(solution.maxTurbulenceSize(new int[] { 1, 1, 2 }));

   }

   // DP solution
   public int maxTurbulenceSize(int[] arr) {
      if (arr.length == 0) {
         return 0;
      } else if (arr.length == 1) {
         return 1;
      }
      int result = 1;
      int[][] dp = new int[arr.length][2];
      for (int[] dpRec : dp) {
         dpRec[0] = dpRec[1] = 1;
      }
      for (int i = 1; i < arr.length; i++) {
         if (arr[i - 1] < arr[i]) {
            dp[i][0] = dp[i - 1][1] + 1;
         } else if (arr[i - 1] > arr[i]) {
            dp[i][1] = dp[i - 1][0] + 1;
         }
         result = Math.max(Math.max(dp[i][0], dp[i][1]), result);
      }
      return result;
   }

   //2 pointers solution
   //   public int maxTurbulenceSize(int[] arr) {
   //      if (arr.length == 0) {
   //         return 0;
   //      } else if (arr.length == 1) {
   //         return 1;
   //      } else if (arr.length == 2) {
   //         if (arr[0] > arr[1] || arr[0] < arr[1]) {
   //            return 2;
   //         }
   //      }
   //      int max = 1;
   //      int left = 0;
   //      int right = 1;
   //      while (right < arr.length - 1) {
   //         while (right < arr.length && ((arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) ||
   //               (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]))) {
   //            right++;
   //         }
   //         while (left < right && arr[left] == arr[left + 1]) {
   //            left++;
   //         }
   //         max = Math.max(max, right - left + 1);
   //         left = right;
   //         right++;
   //      }
   //      return max;
   //   }

   //Leetcode solution
   //   public int maxTurbulenceSize(int[] arr) {
   //      int size = arr.length;
   //      int ans = 1;
   //      int anchor = 0;
   //
   //      for (int i = 1; i < size; ++i) {
   //         int c = Integer.compare(arr[i - 1], arr[i]);
   //         if (c == 0) {
   //            anchor = i;
   //         } else if (i == size - 1 || c * Integer.compare(arr[i], arr[i + 1]) != -1) {
   //            ans = Math.max(ans, i - anchor + 1);
   //            anchor = i;
   //         }
   //      }
   //      return ans;
   //   }

}
