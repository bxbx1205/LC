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
    public void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;

        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        inOrder(root,nums);

        
        
        for(int current:queries){
            // min with binary serach
            int ans=-1;
            int left=0;
            int right=nums.size()-1;
            List<Integer> tempList = new ArrayList<>();

            while(left<=right){
            int mid =  left + (right - left) / 2;

            if(nums.get(mid)>current){
                right=mid-1;
            }
            else{
                ans=nums.get(mid);;
                left=mid+1;
            }
        }
        tempList.add(ans);

        // max with BS

        ans=-1;
        left=0;
        right=nums.size()-1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(nums.get(mid)>=current){
                ans=nums.get(mid);
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        tempList.add(ans);
        ansList.add(tempList);
        }
        return ansList;

    }
}