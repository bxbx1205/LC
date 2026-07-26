/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int trav(TreeNode root,int[] maximum){
        if(root==null){
            return 0;
        }

        int leftSum=Math.max(trav(root.left,maximum),0);
        int rightSum=Math.max(trav(root.right,maximum),0);

        maximum[0]=Math.max(maximum[0],root.val+leftSum+rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
    public int maxPathSum(TreeNode root) {
        int[] maximum= new int[]{Integer.MIN_VALUE};
        trav(root,maximum);

        return maximum[0];
    }
}