package org.codingtasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * @author olysenko
 */
public class CourseSchedule_M_207 {

   public static void main(String[] args) {
      CourseSchedule_M_207 solution = new CourseSchedule_M_207();
      //Input: numCourses = 2, prerequisites = [[1,0]]
      //Output: true
      System.out.println(solution.canFinish(2, new int[][] { { 1, 0 } }));

      //Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
      //Output: false
      System.out.println(solution.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
   }

   public boolean canFinish(int numCourses, int[][] prerequisites) {
      if (numCourses == 1) {
         return true;
      }
      Map<Integer, List<Integer>> preMap = new HashMap<>();
      for (int i = 0; i < numCourses; i++) {
         preMap.put(i, new ArrayList<>());
      }
      for (int[] prerequisite : prerequisites) {
         preMap.get(prerequisite[0]).add(prerequisite[1]);
      }
      Set<Integer> visited = new HashSet<>();
      for (int i = 0; i < numCourses; i++) {
         if (!dfs(i, preMap, visited)) {
            return false;
         }
      }
      return true;
   }

   private boolean dfs(Integer course, Map<Integer, List<Integer>> preMap, Set<Integer> visited) {
      if (visited.contains(course)) {
         return false;
      }
      List<Integer> prerequisites = preMap.get(course);
      if (prerequisites.isEmpty()) {
         return true;
      }

      visited.add(course);
      for (Integer prerequisite : prerequisites) {
         if (!dfs(prerequisite, preMap, visited)) {
            return false;
         }
      }
      visited.remove(course);
      prerequisites.clear();
      return true;
   }

}
