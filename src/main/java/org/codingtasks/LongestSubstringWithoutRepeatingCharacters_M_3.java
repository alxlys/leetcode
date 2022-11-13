package org.codingtasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author olysenko
 */
public class LongestSubstringWithoutRepeatingCharacters_M_3 {

   public static void main(String[] args) {
      LongestSubstringWithoutRepeatingCharacters_M_3 solution = new LongestSubstringWithoutRepeatingCharacters_M_3();
      //Input: s = "abcabcbb"
      //Output: 3
      //Explanation: The answer is "abc", with the length of 3.
      System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));

      //Input: s = "bbbbb"
      //Output: 1
      //Explanation: The answer is "b", with the length of 1.
      System.out.println(solution.lengthOfLongestSubstring("bbbbb"));

      //Input: s = "pwwkew"
      //Output: 3
      //Explanation: The answer is "wke", with the length of 3.
      //Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
      System.out.println(solution.lengthOfLongestSubstring("pwwkew"));

      //Input: s = "abba"
      //Output: 2
      System.out.println(solution.lengthOfLongestSubstring("abba"));
   }

   public int lengthOfLongestSubstring(String s) {
      HashSet<Character> set = new HashSet<>();
      int left = 0;
      int ans = 0;
      for (int right = 0; right < s.length(); right++) {
         while (set.contains(s.charAt(right))) {
            set.remove(s.charAt(left));
            left++;
         }
         set.add(s.charAt(right));
         ans = Math.max(ans, right - left + 1);
      }
      return ans;
   }

   //Map solution
//   public int lengthOfLongestSubstring(String s) {
//      int maxLength = 0;
//      int left = 0;
//      Map<Character, Integer> characterMap = new HashMap<>();
//      for (int right = 0; right < s.length(); right++) {
//         char c = s.charAt(right);
//         if (characterMap.containsKey(c)) {
//            Integer index = characterMap.get(c);
//            left = ++index;
//            Iterator<Map.Entry<Character, Integer>> iter = characterMap.entrySet().iterator();
//            while (iter.hasNext()) {
//               Map.Entry<Character, Integer> entry = iter.next();
//               if (entry.getValue() < left) {
//                  iter.remove();
//               }
//            }
//         }
//         characterMap.put(c, right);
//         maxLength = Math.max(maxLength, right - left + 1);
//      }
//      return maxLength;
//   }

}
