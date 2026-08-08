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
    int ans=0;
    int cnt=0;
    public void inOrder(TreeNode root,int k){
        if (root == null) return;
        if (cnt >= k) return;
        if(root.left!=null){
            inOrder(root.left,k);
        }
        cnt++;
        if(cnt==k){
            ans=root.val;
        }
        if(root.right!=null){
            inOrder(root.right,k);
        }
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
    }
}