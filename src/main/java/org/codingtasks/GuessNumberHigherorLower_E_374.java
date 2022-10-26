package org.codingtasks;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 *
 * @author olysenko
 */
public class GuessNumberHigherorLower_E_374 {

   public static void main(String[] args) {
      GuessNumberHigherorLower_E_374 solution = new GuessNumberHigherorLower_E_374();
      //Input: n = 10, pick = 6
      //Output: 6
      solution.pick = 6;
      System.out.println(solution.guessNumber(10));

      //Input: n = 1, pick = 1
      //Output: 1
      solution.pick = 1;
      System.out.println(solution.guessNumber(1));

      //Input: n = 2, pick = 1
      //Output: 1
      solution.pick = 1;
      System.out.println(solution.guessNumber(2));

      //2126753390
      //1702766719
      solution.pick = 1702766719;
      System.out.println(solution.guessNumber(2126753390));

   }

   private int pick;

   private int guess(int num) {
      //-1: Your guess is higher than the number I picked (i.e. num > pick).
      //1: Your guess is lower than the number I picked (i.e. num < pick).
      //0: your guess is equal to the number I picked (i.e. num == pick).
      return Integer.compare(pick, num);
      //      if (num > pick) {
      //         return -1;
      //      } else if (num < pick) {
      //         return 1;
      //      } else {
      //         return 0;
      //      }
   }

   public int guessNumber(int n) {
      long left = 0;
      long right = n;

      while (left <= right) {
         long mid = (left + right) / 2;
         int guess = guess((int) mid);
         if (guess == 1) {
            left = mid + 1;
         } else if (guess == -1) {
            right = mid - 1;
         } else {
            return (int) mid;
         }
      }
      return -1;
   }

}
