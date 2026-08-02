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
    public int getLeftHeight(TreeNode root){
        int cnt=0;

        while(root!=null){
            root=root.left;
            cnt++;
        }

        return cnt;
    }
    public int getRightHeight(TreeNode root){
        int cnt=0;

        while(root!=null){
            root=root.right;
            cnt++;
        }

        return cnt;
    }

    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int leftH=getLeftHeight(root);
        int rightH=getRightHeight(root);

        if(leftH==rightH) return (int) Math.pow(2,rightH)-1;
        else return 1 + (countNodes(root.left))+(countNodes(root.right));
    }
}