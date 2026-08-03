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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            double levelSum=0;

            for(int i=0;i<n;i++){
                TreeNode current = queue.poll();
                levelSum+=current.val;

                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }

            ans.add(levelSum/n);
        }

        return ans;
    }
}