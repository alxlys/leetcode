package org.codingtasks;

/**
 * https://leetcode.com/problems/fibonacci-number/
 *
 * @author olysenko
 */
public class FibonacciNumber_E_509 {

   public static void main(String[] args) {
      FibonacciNumber_E_509 solution = new FibonacciNumber_E_509();
      // Input: n = 2
      // Output: 1
      System.out.println(solution.fib(2));

      // Input: n = 3
      // Output: 2
      System.out.println(solution.fib(3));

      // Input: n = 4
      // Output: 3
      System.out.println(solution.fib(4));

   }

   public int fib(int n) {
      if (n <= 1) {
         return n;
      }
      return fib(n - 1) + fib(n - 2);
   }

}
