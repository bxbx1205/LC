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
    public TreeNode insertIntoBST(TreeNode root, int val) {
         if (root == null) {
            return new TreeNode(val);
        }
        TreeNode rot=root;
        TreeNode prev=rot;
        while(rot!=null){
            if(rot.val>val){
                prev=rot;
                rot=rot.left;
            }
            else{
                prev=rot;
                rot=rot.right;
            }
        }
         if (prev.val > val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }

        return root;
    }
}