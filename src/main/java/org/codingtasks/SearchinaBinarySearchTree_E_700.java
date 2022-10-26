package org.codingtasks;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * @author olysenko
 */
public class SearchinaBinarySearchTree_E_700 {

   public static void main(String[] args) {
      SearchinaBinarySearchTree_E_700 solution = new SearchinaBinarySearchTree_E_700();
      //Input: root = [4,2,7,1,3], val = 2
      //Output: [2,1,3]
      System.out.println(
            solution.searchBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)), 2));

      //Input: root = [4,2,7,1,3], val = 5
      //Output: []
      System.out.println(
            solution.searchBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)), 5));
   }

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

   public TreeNode searchBST(TreeNode root, int val) {
      if (root == null) {
         return null;
      }
      if (root.val > val) {
         return searchBST(root.left, val);
      } else if (root.val < val) {
         return searchBST(root.right, val);
      } else {
         return root;
      }
   }
}
