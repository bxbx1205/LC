/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findPath(TreeNode root, TreeNode target, ArrayList<TreeNode> path) {
        if (root == null)
            return false;

        path.add(root);

        if (root == target)
            return true;

        if (findPath(root.left, target, path) || findPath(root.right, target, path))
            return true;

        path.remove(path.size() - 1);

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathP = new ArrayList<>();
        ArrayList<TreeNode> pathQ = new ArrayList<>();

        findPath(root, p, pathP);
        findPath(root, q, pathQ);
        TreeNode ans=q;

        for(int i=0;i<Math.min(pathP.size(),pathQ.size());i++){
            if(pathP.get(i)==pathQ.get(i)){
                ans=pathP.get(i);
            }
        }
        return ans;
    }
}