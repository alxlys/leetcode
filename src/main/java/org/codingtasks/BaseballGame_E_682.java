package org.codingtasks;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/baseball-game/
 *
 * @author olysenko
 */
public class BaseballGame_E_682 {

   public static void main(String[] args) {
      BaseballGame_E_682 solution = new BaseballGame_E_682();
      // Input: ops = ["5","2","C","D","+"]
      // Output: 30
      System.out.println(solution.calPoints(new String[] { "5", "2", "C", "D", "+" }));

      // Input: ops = ["5","-2","4","C","D","9","+","+"]
      // Output: 27
      System.out.println(solution.calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));

      // Input: ops = ["1","C"]
      // Output: 0
      System.out.println(solution.calPoints(new String[] { "1", "C" }));
   }

   public int calPoints(String[] operations) {
      List<Integer> stack = new ArrayList<>();

      for (String op : operations) {
         try {
            int num = Integer.parseInt(op);
            stack.add(num);
            continue;
         } catch (Exception e) {
            //noop
         }
         switch (op) {
            case "+":
               stack.add(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
               break;
            case "D":
               stack.add(stack.get(stack.size() - 1) * 2);
               break;
            case "C":
               stack.remove(stack.size() - 1);
         }
      }
      return stack.stream().mapToInt(i -> i).sum();
   }
}
