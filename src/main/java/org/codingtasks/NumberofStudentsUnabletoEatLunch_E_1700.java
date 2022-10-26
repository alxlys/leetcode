package org.codingtasks;

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 *
 * @author olysenko
 */
public class NumberofStudentsUnabletoEatLunch_E_1700 {

   public static void main(String[] args) {
      NumberofStudentsUnabletoEatLunch_E_1700 solution = new NumberofStudentsUnabletoEatLunch_E_1700();
      // Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
      // Output: 0
      System.out.println(solution.countStudents(new int[] { 1, 1, 0, 0 }, new int[] { 0, 1, 0, 1 }));

      // Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
      // Output: 3
      System.out.println(solution.countStudents(new int[] { 1, 1, 1, 0, 0, 1 }, new int[] { 1, 0, 0, 0, 1, 1 }));

   }

   public int countStudents(int[] students, int[] sandwiches) {
      int index = 0;
      int moves = 0;
      while (index < sandwiches.length && moves < students.length - index) {
         if (sandwiches[index] == students[index]) {
            index++;
            moves = 0;
         } else {
            int student = students[index];
            System.arraycopy(students, index + 1, students, index, students.length - index - 1);
            students[students.length - 1] = student;
            moves++;
         }
      }
      return students.length - index;
   }

}
