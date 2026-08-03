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
    public TreeNode build(int[] inorder, int inStart, int inEnd,int[] postorder,int postStart, int postEnd,HashMap<Integer,Integer> map){

        if(inStart>inEnd || postStart>postEnd){
            return null;
        }

        TreeNode root =  new TreeNode(postorder[postEnd]);
        int inIndex= map.get(root.val);
        int left=inIndex-inStart;
        int n = inorder.length;

        root.left=build(inorder,inStart,inIndex-1,postorder,postStart,postStart+left-1,map);
        root.right=build(inorder,inIndex+1,inEnd,postorder,postStart+left,postEnd-1,map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = inorder.length;
        // we found index and store in map
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }

        // recursion

        TreeNode root = build(inorder,0,n-1,postorder,0,n-1,map);

        return root;
    }
}