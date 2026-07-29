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
    int currentSum=0;

    public void trav(TreeNode root,int sum){
        if(root==null) return;

        sum=sum*10+root.val;
        if(root.left==null && root.right ==null){
            currentSum+=sum;
            return;
        }

        trav(root.left,sum);
        trav(root.right,sum);
    } 

    public int sumNumbers(TreeNode root) {
        
        trav(root,0);
        return currentSum;
    }
}