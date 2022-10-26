package org.codingtasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * @author olysenko
 */
public class BinaryTreeLevelOrderTraversal_M_102 {

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
      BinaryTreeLevelOrderTraversal_M_102 solution = new BinaryTreeLevelOrderTraversal_M_102();
      //Input: root = [3,9,20,null,null,15,7]
      //Output: [[3],[9,20],[15,7]]
      System.out.println(
            solution.levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
   }

   public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      Queue<TreeNode> queue = new ArrayDeque<>();
      if (root == null) {
         return result;
      }
      queue.add(root);

      while (!queue.isEmpty()) {
         List<Integer> level = new ArrayList<>();
         int len = queue.size();
         for (int i = 0; i < len; i++) {
            TreeNode treeNode = queue.poll();
            level.add(treeNode.val);
            if (treeNode.left != null) {
               queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
               queue.add(treeNode.right);
            }
         }
         result.add(level);
      }
      return result;
   }
}
