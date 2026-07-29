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
    public void trav(TreeNode root,int targetSum,List<List<Integer>> ans,List<Integer> temp){
        if(root==null) return;
        if(root.left==null && root.right==null && root.val==targetSum){
            temp.add(root.val);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        temp.add(root.val);
        trav(root.left,targetSum-root.val,ans,temp);
        trav(root.right,targetSum-root.val,ans,temp);

        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        trav(root,targetSum,ans,new ArrayList<>());

        return ans;
    }
}