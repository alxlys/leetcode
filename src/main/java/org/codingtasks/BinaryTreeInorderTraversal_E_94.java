package org.codingtasks;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * @author olysenko
 */
public class BinaryTreeInorderTraversal_E_94 {

   private static class TreeNode {
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
      BinaryTreeInorderTraversal_E_94 solution = new BinaryTreeInorderTraversal_E_94();
      //Input: root = [1,null,2,3]
      //Output: [1,3,2]
      System.out.println(solution.inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));

   }

   public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      inorder(root, result);
      return result;
   }

   private void inorder(TreeNode root, List<Integer> result) {
      if (root == null) {
         return;
      }
      inorder(root.left, result);
      result.add(root.val);
      inorder(root.right, result);
   }
}
