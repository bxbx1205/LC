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
    public boolean trav(TreeNode root, long min, long max){
        if(root==null) return true;
        // min=Math.min(min,root.val);
        // max=Math.max(max,root.val);

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return trav(root.left,min,root.val) && trav(root.right,root.val ,max);
    }
    public boolean isValidBST(TreeNode root) {
        return trav(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}