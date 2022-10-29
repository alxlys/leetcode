package org.codingtasks;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 * @author olysenko
 */
public class Subsets_M_78 {

   public static void main(String[] args) {
      Subsets_M_78 solution = new Subsets_M_78();
      //Input: nums = [1,2,3]
      //Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
      System.out.println(solution.subsets(new int[] { 1, 2, 3 }));

      //Input: nums = [0]
      //Output: [[],[0]]
      System.out.println(solution.subsets(new int[] { 0 }));
   }

   //The idea is to have two conditions: One in which we will take the element into consideration,
   //Second in which we won't take the element into consideration.
   //This video was good for code explanation. https://www.youtube.com/watch?v=6BPurabdAl4&t=508s&ab_channel=Fraz
   public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> list = new ArrayList<>();
      helper(ans, 0, nums, list);
      return ans;
   }

   public void helper(List<List<Integer>> ans, int start, int[] nums, List<Integer> list) {
      if (start >= nums.length) {
         //In java, we will have to add like this otherwise it'll give null as it'll
         //just have the reference instead of actual values.
         ans.add(new ArrayList<>(list));
      } else {
         //add the element and start the  recursive call
         list.add(nums[start]);
         helper(ans, start + 1, nums, list);
         //remove the element and do the backtracking call.
         list.remove(list.size() - 1);
         helper(ans, start + 1, nums, list);
      }
   }

}