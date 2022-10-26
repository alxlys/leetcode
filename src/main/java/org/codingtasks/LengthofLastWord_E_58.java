package org.codingtasks;

/**
 * https://leetcode.com/problems/length-of-last-word/
 *
 * @author olysenko
 */
public class LengthofLastWord_E_58 {

   public static void main(String[] args) {
      LengthofLastWord_E_58 solution = new LengthofLastWord_E_58();

      //s = "Hello World"
      String s = "Hello World";
      System.out.println(solution.lengthOfLastWord(s));

      //s = "   fly me   to   the moon  "
      s = "   fly me   to   the moon  ";
      System.out.println(solution.lengthOfLastWord(s));

      //s = "luffy is still joyboy"
      s = "luffy is still joyboy";
      System.out.println(solution.lengthOfLastWord(s));

   }

   public int lengthOfLastWord(String s) {
      String[] words = s.split(" ");
      return words[words.length - 1].length();
   }
}
