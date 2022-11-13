package org.codingtasks;

/**
 * https://leetcode.com/problems/valid-palindrome/
 *
 * @author olysenko
 */
public class ValidPalindrome_E_125 {

   public static void main(String[] args) {
      ValidPalindrome_E_125 solution = new ValidPalindrome_E_125();
      //Input: s = "A man, a plan, a canal: Panama"
      //Output: true
      //Explanation: "amanaplanacanalpanama" is a palindrome.
      System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));

      //Input: s = "race a car"
      //Output: false
      //Explanation: "raceacar" is not a palindrome.
      System.out.println(solution.isPalindrome("race a car"));

      System.out.println(solution.isPalindrome(" "));
   }

   public boolean isPalindrome(String s) {
      int left = 0;
      int right = s.length() - 1;

      while (left <= right) {
         while (left <= right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
         }
         while (right >= left && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
         }
         if (left > right) {
            break;
         }
         if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
         }
         left++;
         right--;
      }
      return true;
   }

}
