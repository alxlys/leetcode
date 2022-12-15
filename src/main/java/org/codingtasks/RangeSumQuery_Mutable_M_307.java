package org.codingtasks;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * @author olysenko
 */
public class RangeSumQuery_Mutable_M_307 {

   public static void main(String[] args) {
      //Input
      //["NumArray", "sumRange", "update", "sumRange"]
      //[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
      //Output
      //[null, 9, null, 8]
      //
      //Explanation
//      NumArray numArray = new NumArray(new int[] { 1, 3, 5 });
//      System.out.println(numArray.sumRange(0, 2)); // return 1 + 3 + 5 = 9
//      numArray.update(1, 2);                       // nums = [1, 2, 5]
//      System.out.println(numArray.sumRange(0, 2)); // return 1 + 2 + 5 = 8

      //["NumArray","sumRange","sumRange","sumRange","update","update","update","sumRange","update","sumRange","update"]
      //[[[0,9,5,7,3]],[4,4],[2,4],[3,3],[4,5],[1,7],[0,8],[1,2],[1,9],[4,4],[3,4]]
      NumArray numArray = new NumArray(new int[] { 0, 9, 5, 7, 3 });
//      System.out.println(numArray.sumRange(4,4));
      System.out.println(numArray.sumRange(2,4));

   }

   static class NumArray {

      static class SegmentTree {
         int sum;
         SegmentTree left;
         SegmentTree right;
         int l;
         int r;

         public SegmentTree(int l, int r) {
            this.l = l;
            this.r = r;
         }

         public SegmentTree(int sum, int l, int r) {
            this(l, r);
            this.sum = sum;
         }

         // O(logN)
         public void update(int index, int val) {
            if (this.l == this.r) {
               this.sum = val;
               return;
            }
            int m = (this.l + this.r) / 2;
            if (index > m) {
               this.right.update(index, val);
            } else {
               this.left.update(index, val);
            }
            this.sum = this.left.sum + this.right.sum;
         }

         // O(logN)
         public int sumRange(int left, int right) {
            if (left == this.l && right == this.r) {
               return this.sum;
            }
            int m = (this.l + this.r) / 2;
            if (left > m) {
               return this.right.sumRange(left, right);
            } else if (right <= m) {
               return this.left.sumRange(left, right);
            } else {
               return this.left.sumRange(left, m) + this.right.sumRange(m + 1, right);
            }
         }
      }

      private final SegmentTree segmentTree;

      public NumArray(int[] nums) {
         this.segmentTree = buildTree(nums, 0, nums.length - 1);
      }

      // O(n)
      private static SegmentTree buildTree(int[] nums, int l, int r) {
         if (l == r) {
            return new SegmentTree(nums[l], l, r);
         }
         SegmentTree root = new SegmentTree(l, r);
         int m = (l + r) / 2;
         root.left = buildTree(nums, l, m);
         root.right = buildTree(nums, m + 1, r);
         root.sum = root.left.sum + root.right.sum;
         return root;
      }

      // O(logN)
      public void update(int index, int val) {
         this.segmentTree.update(index, val);
      }

      // O(logN)
      public int sumRange(int left, int right) {
         return this.segmentTree.sumRange(left, right);
      }
   }

}
