package org.codingtasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * @author olysenko
 */
public class BinaryTreeRightSideView_M_199 {

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
      BinaryTreeRightSideView_M_199 solution = new BinaryTreeRightSideView_M_199();
      //Input: root = [1,2,3,null,5,null,4]
      //Output: [1,3,4]
      System.out.println(solution.rightSideView(
            new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)))));

   }

   public List<Integer> rightSideView(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Queue<TreeNode> queue = new ArrayDeque<>();
      if (root == null) {
         return result;
      }
      queue.add(root);

      while (!queue.isEmpty()) {
         int len = queue.size();
         Integer rightMostValue = null;
         for (int i = 0; i < len; i++) {
            TreeNode treeNode = queue.poll();
            rightMostValue = treeNode.val;
            if (treeNode.left != null) {
               queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
               queue.add(treeNode.right);
            }
         }
         result.add(rightMostValue);
      }
      return result;
   }

}
