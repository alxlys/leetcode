package org.codingtasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author olysenko
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_M_105 {

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

      @Override
      public String toString() {
         return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
      }
   }

   public static void main(String[] args) {
      ConstructBinaryTreefromPreorderandInorderTraversal_M_105 solution =
            new ConstructBinaryTreefromPreorderandInorderTraversal_M_105();
      //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
      //Output: [3,9,20,null,null,15,7]

      TreeNode tree = solution.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
      System.out.println(tree);
   }

   // No array copy version
//   Map<Integer, Integer> inorderPositions = new HashMap<>();
//
//   public TreeNode buildTree(int[] preorder, int[] inorder) {
//      if (preorder.length < 1 || inorder.length < 1) {
//         return null;
//      }
//
//      for (int i = 0; i < inorder.length; i++) {
//         inorderPositions.put(inorder[i], i);
//      }
//
//      return builder(preorder, 0, 0, inorder.length - 1);
//   }
//
//   public TreeNode builder(int[] preorder, int preorderIndex, int inorderLow, int inorderHigh) {
//      if (preorderIndex > preorder.length - 1 || inorderLow > inorderHigh)
//         return null;
//
//      int currentVal = preorder[preorderIndex];
//      TreeNode n = new TreeNode(currentVal);
//      int mid = inorderPositions.get(currentVal);
//
//      n.left = builder(preorder, preorderIndex + 1, inorderLow, mid - 1);
//      n.right = builder(preorder, preorderIndex + (mid - inorderLow) + 1, mid + 1, inorderHigh);
//
//      return n;
//   }

   public TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder.length == 0 || inorder.length == 0) {
         return null;
      }

      TreeNode root = new TreeNode(preorder[0]);
      int mid = 0;
      for (int i = 0; i < inorder.length; i++) {
         if (preorder[0] == inorder[i]) {
            mid = i;
         }
      }

      root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
      root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
            Arrays.copyOfRange(inorder, mid + 1, inorder.length));

      return root;
   }

}
