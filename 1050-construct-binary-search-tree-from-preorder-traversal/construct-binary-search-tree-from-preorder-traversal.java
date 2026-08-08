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
    public void helper(TreeNode root, int current){
        if(root==null) return;
        TreeNode prev=root;

        while(root!=null){
            if(root.val>current){
                prev=root;
                root=root.left;        
            }
            else{
                prev=root;
                root=root.right;
            }
        }

        if(prev.val>current){
            prev.left=new TreeNode(current);
        }
        else{
            prev.right=new TreeNode(current);
        }
        return;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root= new TreeNode(preorder[0]);
        int n = preorder.length;
        TreeNode og = root;

        for(int i=1;i<n;i++){
            int current=preorder[i];
            helper(root,current);
            root=og;
        }

        return root;
    }
}