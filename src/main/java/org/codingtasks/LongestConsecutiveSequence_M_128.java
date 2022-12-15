package org.codingtasks;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * @author olysenko
 */
public class LongestConsecutiveSequence_M_128 {

   public static void main(String[] args) {
      LongestConsecutiveSequence_M_128 solution = new LongestConsecutiveSequence_M_128();
      //Input: nums = [100,4,200,1,3,2]
      //Output: 4
      //Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
      System.out.println(solution.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));

      //Input: nums = [0,3,7,2,5,8,4,6,0,1]
      //Output: 9
      System.out.println(solution.longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
   }

   public int longestConsecutive(int[] nums) {
      Set<Integer> numSet = new HashSet<>();
      for (int num : nums) {
         numSet.add(num);
      }
      int maxSeq = 0;
      for (int num : nums) {
         if (!numSet.contains(num - 1)) {
            int length = 0;
            while (numSet.contains(num + length)) {
               length++;
            }
            maxSeq = Math.max(maxSeq, length);
         }
      }
      return maxSeq;
   }

}
