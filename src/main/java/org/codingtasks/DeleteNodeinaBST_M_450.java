package org.codingtasks;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * @author olysenko
 */
public class DeleteNodeinaBST_M_450 {

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
      DeleteNodeinaBST_M_450 solution = new DeleteNodeinaBST_M_450();
      //Input: root = [5,3,6,2,4,null,7], key = 3
      //Output: [5,4,6,2,null,null,7]
      System.out.println(solution.deleteNode(
            new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7))),
            3));
   }


   public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) {
         return null;
      }
      if (key > root.val) {
         root.right = deleteNode(root.right, key);
      } else if (key < root.val) {
         root.left = deleteNode(root.left, key);
      } else {
         if (root.right == null) {
            return root.left;
         } else if (root.left == null) {
            return root.right;
         } else {
            TreeNode minNode = minValueNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
         }
      }
      return root;
   }

   private TreeNode minValueNode(TreeNode root) {
      TreeNode current = root;
      while (current != null && current.left != null) {
         current = current.left;
      }
      return current;
   }

}
