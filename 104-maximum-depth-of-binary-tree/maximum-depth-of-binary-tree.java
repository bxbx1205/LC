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
    public int trav(TreeNode root,int depth){
        if(root==null) return depth;

        int leftMax=trav(root.left,depth+1);
        int rightMax=trav(root.right,depth+1);

        return Math.max(leftMax,rightMax);
    }
    public int maxDepth(TreeNode root) {
        return trav(root,0);
    }
}