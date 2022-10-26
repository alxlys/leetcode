package org.codingtasks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author olysenko
 */
public class ValidParentheses_E_20 {

   public static void main(String[] args) {
      ValidParentheses_E_20 solution = new ValidParentheses_E_20();
      String s = "()";
      System.out.println(s + " is valid: " + solution.isValid(s));
      s = "()[]{}";
      System.out.println(s + " is valid: " + solution.isValid(s));
      s = "(]";
      System.out.println(s + " is valid: " + solution.isValid(s));
      s = "{[]}";
      System.out.println(s + " is valid: " + solution.isValid(s));
      s = "((";
      System.out.println(s + " is valid: " + solution.isValid(s));
   }

   public boolean isValid(String s) {
      if (s.length() < 2) {
         return false;
      }
      Map<String, String> parenthesesMap = new HashMap<>();
      parenthesesMap.put("(", ")");
      parenthesesMap.put("[", "]");
      parenthesesMap.put("{", "}");

      LinkedList<String> stack = new LinkedList<>();
      for (int i = 0; i < s.length(); i++) {
         String c = s.substring(i, i + 1);
         if (parenthesesMap.containsKey(c)) {
            stack.push(c);
         } else if (parenthesesMap.containsValue(c)) {
            if (stack.isEmpty()) {
               return false;
            }
            String openParentheses = stack.poll();
            String closeParentheses = parenthesesMap.get(openParentheses);
            if (!closeParentheses.equals(c)) {
               return false;
            }
         } else {
            throw new IllegalStateException();
         }
      }
      return stack.isEmpty();
   }

}
