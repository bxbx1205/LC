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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root==null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean rl=false;
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0;i<n;i++){
                TreeNode node =queue.poll();
                list.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }

            if(rl==true){
                Collections.reverse(list);
            }
            rl=!rl;

            ans.add(list);
        }
        return ans;
    }
}