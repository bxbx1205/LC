class Solution {

    int max = 0;   

    public int diameterOfBinaryTree(TreeNode root) {
        trav(root);
        return max;
    }

    public int trav(TreeNode root) {
        if (root == null) return 0;

        int leftH = trav(root.left);
        int rightH = trav(root.right);

        max = Math.max(max, leftH + rightH);

        return 1 + Math.max(leftH, rightH);
    }
}