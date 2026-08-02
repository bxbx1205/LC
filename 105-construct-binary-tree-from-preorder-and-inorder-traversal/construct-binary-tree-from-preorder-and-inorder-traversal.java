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
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,HashMap<Integer,Integer> map){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex=map.get(root.val);

        int numLeft=inIndex-inStart;

        root.left=(build(preorder,preStart+1,preStart+numLeft,inorder,inStart,inIndex-1,map));
        root.right=(build(preorder,preStart+numLeft+1,preEnd,inorder,inIndex + 1, inEnd,map));

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = build(preorder, 0, n - 1, inorder, 0, n - 1, map);

        return root;
    }
}