package org.codingtasks;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 * @author olysenko
 */
public class CombinationSum_M_39 {

   public static void main(String[] args) {
      CombinationSum_M_39 solution = new CombinationSum_M_39();
      //Input: candidates = [2,3,6,7], target = 7
      //Output: [[2,2,3],[7]]
      System.out.println(solution.combinationSum(new int[] { 2, 3, 6, 7 }, 7));

      //Input: candidates = [2,3,5], target = 8
      //Output: [[2,2,2,2],[2,3,3],[3,5]]
      System.out.println(solution.combinationSum(new int[] { 2, 3, 5 }, 8));

      //Input: candidates = [2], target = 1
      //Output: []
      System.out.println(solution.combinationSum(new int[] { 2 }, 1));
   }

   public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> list = new ArrayList<>();
      helper(res, 0, candidates, list, target);
      return res;
   }

   public void helper(List<List<Integer>> res, int idx, int[] candidates, List<Integer> list, int target) {
      int sum = list.stream().mapToInt(i -> i).sum();
      if (sum == target) {
         res.add(new ArrayList<>(list));
      } else if (sum > target || idx >= candidates.length) {
         // no sense to proceed
         return;
      } else {
         // trying with the same value
         list.add(candidates[idx]);
         helper(res, idx, candidates, list, target);

         // removing last value and trying with other values
         if (!list.isEmpty()) {
            list.remove(list.size() - 1);
         }
         idx++;
         helper(res, idx, candidates, list, target);
      }
   }

//   public List<List<Integer>> combinationSum(int[] candidates, int target) {
//      List<List<Integer>> ans = new ArrayList<List<Integer>>();
//      List<Integer> cur = new ArrayList();
//      backtrack(candidates, target, ans, cur, 0);
//      return ans;
//   }
//
//   public void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> cur, int index) {
//      if (target == 0) {
//         ans.add(new ArrayList(cur));
//      } else if (target < 0 || index >= candidates.length) {
//         return;
//      } else {
//         cur.add(candidates[index]);
//         backtrack(candidates, target - candidates[index], ans, cur, index);
//
//         cur.remove(cur.get(cur.size() - 1));
//         backtrack(candidates, target, ans, cur, index + 1);
//      }
//   }
}
