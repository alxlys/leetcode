package org.codingtasks;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * @author olysenko
 */
public class InsertintoaBinarySearchTree_M_701 {

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
      InsertintoaBinarySearchTree_M_701 solution = new InsertintoaBinarySearchTree_M_701();
      //Input: root = [4,2,7,1,3], val = 5
      //Output: [4,2,7,1,3,5]
      System.out.println(solution
            .insertIntoBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)), 2));

   }

   public TreeNode insertIntoBST(TreeNode root, int val) {
      if (root == null) {
         return new TreeNode(val);
      }
      if (val > root.val) {
         root.right = insertIntoBST(root.right, val);
      } else if (val < root.val) {
         root.left = insertIntoBST(root.left, val);
      }
      return root;
   }

}
