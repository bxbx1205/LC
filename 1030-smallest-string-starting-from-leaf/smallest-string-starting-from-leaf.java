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
    public void dfs(TreeNode root, StringBuilder ans, StringBuilder current) {
        if (root == null)
            return;
        current.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {

            current.reverse();
            String temp = current.toString();
            if (ans.length() == 0 || temp.compareTo(ans.toString()) < 0) {
                ans.setLength(0);
                ans.append(temp);
            }

            current.reverse();
        }

        dfs(root.left, ans, current);
        dfs(root.right, ans, current);
        current.deleteCharAt(current.length() - 1);
    }

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        // Stack<TreeNode> st = new Stack<>();
        dfs(root, ans, new StringBuilder());

        return ans.toString();
    }
}