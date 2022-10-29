package org.codingtasks;

/**
 * https://leetcode.com/problems/path-sum/
 *
 * @author olysenko
 */
public class PathSum_E_112 {

   public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {
      }

      TreeNode(int val) {
         this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }

   public static void main(String[] args) {
      PathSum_E_112 solution = new PathSum_E_112();
      //Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
      //Output: true
      System.out.println(solution.hasPathSum(
            new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                  new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))), 22));

      //Input: root = [1,2,3], targetSum = 5
      //Output: false
      System.out.println(solution.hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 5));

      //Input: root = [], targetSum = 0
      //Output: false
      System.out.println(solution.hasPathSum(null, 0));
   }

   public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) {
         return false;
      }

      return calcPathSum(root, 0, targetSum);
   }

   private boolean calcPathSum(TreeNode node, int accumulatedSum, int targetSum) {
      accumulatedSum += node.val;
      // if leaf node check the sum
      if (node.left == null && node.right == null) {
         return accumulatedSum == targetSum;
      }

      return (node.left != null && calcPathSum(node.left, accumulatedSum, targetSum)) ||
            (node.right != null && calcPathSum(node.right, accumulatedSum, targetSum));
   }

}
