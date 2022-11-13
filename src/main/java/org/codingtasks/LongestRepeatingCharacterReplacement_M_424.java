package org.codingtasks;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * @author olysenko
 */
public class LongestRepeatingCharacterReplacement_M_424 {

   public static void main(String[] args) {
      LongestRepeatingCharacterReplacement_M_424 solution = new LongestRepeatingCharacterReplacement_M_424();
      //Input: s = "ABAB", k = 2
      //Output: 4
      //Explanation: Replace the two 'A's with two 'B's or vice versa.
      System.out.println(solution.characterReplacement("ABAB", 2));

      //Input: s = "AABABBA", k = 1
      //Output: 4
      //Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
      //The substring "BBBB" has the longest repeating letters, which is 4.
      System.out.println(solution.characterReplacement("AABABBA", 1));
   }

//   public int characterReplacement(String s, int k) {
//      Map<Character, Integer> charMap = new HashMap<>();
//      int left = 0;
//      int maxLength = 0;
//
//      for (int right = 0; right < s.length(); right++) {
//         charMap.merge(s.charAt(right), 1, Integer::sum);
//         if (right - left + 1 - charMap.values().stream().mapToInt(c -> c).max().getAsInt() > k) {
//            charMap.put(s.charAt(left), charMap.get(s.charAt(left)) - 1);
//            left++;
//         }
//         maxLength = Math.max(maxLength, right - left + 1);
//      }
//      return maxLength;
//   }

   public int characterReplacement(String s, int k) {
      Map<Character, Integer> charMap = new HashMap<>();
      int left = 0;
      int maxLength = 0;
      int maxFreq = 0;

      for (int right = 0; right < s.length(); right++) {
         Integer count = charMap.merge(s.charAt(right), 1, Integer::sum);
         maxFreq = Math.max(maxFreq, count);
         if (right - left + 1 - maxFreq > k) {
            charMap.put(s.charAt(left), charMap.get(s.charAt(left)) - 1);
            left++;
         }
         maxLength = Math.max(maxLength, right - left + 1);
      }
      return maxLength;
   }

//   public int characterReplacement(String s, int k) {
//      int[] arr = new int[26];
//      int ans = 0;
//      int max = 0;
//      int i = 0;
//      for (int j = 0; j < s.length(); j++) {
//         arr[s.charAt(j) - 'A']++;
//         max = Math.max(max, arr[s.charAt(j) - 'A']);
//         if (j - i + 1 - max > k) {
//            arr[s.charAt(i) - 'A']--;
//            i++;
//         }
//         ans = Math.max(ans, j - i + 1);
//      }
//      return ans;
//   }


}
