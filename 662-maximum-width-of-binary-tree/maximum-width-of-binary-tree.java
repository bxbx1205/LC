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
class Pair{
    TreeNode node;
    int index;

    Pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue= new LinkedList<>();
        int maxWidth=0;

        queue.offer(new Pair(root,0));

        while(!queue.isEmpty()){
            int n = queue.size();
            int minIndex = queue.peek().index;
            int start=0;
            int end=0;

            for(int i=0;i<n;i++){
                Pair currentPair=queue.poll();
                // int index = currentPair.index - minIndex;
                // int index=currentPair.index-start;
                int index = currentPair.index - minIndex;
                TreeNode node = currentPair.node;

                if (i == 0) start = index;
                if (i == n - 1) end = index;

                 if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 2));
                }
            }

            maxWidth=Math.max(maxWidth,end-start+1);
        }

        return maxWidth;

    }
}