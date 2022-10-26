package org.codingtasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * @author olysenko
 */
public class KthSmallestElementinaBST_M_230 {

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
      KthSmallestElementinaBST_M_230 solution = new KthSmallestElementinaBST_M_230();
      //Input: root = [3,1,4,null,2], k = 1
      //Output: 1
      System.out
            .println(solution.kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1));

   }

   public int kthSmallest(TreeNode root, int k) {
      return kthSmallestStack(root, k);
   }

   public int kthSmallestStack(TreeNode root, int k) {
      //      this is a stack and loop solution
      int n = 0;
      LinkedList<TreeNode> stack = new LinkedList<>();
      TreeNode current = root;

      while (current != null || !stack.isEmpty()) {
         while (current != null) {
            stack.push(current);
            current = current.left;
         }

         current = stack.pop();
         n++;
         if (n == k) {
            break;
         }
         current = current.right;
      }
      return current.val;
   }

   public int kthSmallestRec(TreeNode root, int k) {
      //            this is a recursive solution
      List<Integer> values = new ArrayList<>();
      inorder(root, values);
      return values.get(k - 1);
   }

   private void inorder(TreeNode root, List<Integer> values) {
      if (root == null) {
         return;
      }
      inorder(root.left, values);
      values.add(root.val);
      inorder(root.right, values);
   }

}
