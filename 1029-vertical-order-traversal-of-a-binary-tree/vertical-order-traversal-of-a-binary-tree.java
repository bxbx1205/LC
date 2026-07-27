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
 class Tuple{
    TreeNode node;
    int col;
    int row;

    Tuple(TreeNode node,int col,int row){
        this.node=node;
        this.col=col;
        this.row=row;
    }

 }
class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();

         q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple current = q.poll();

            TreeNode node = current.node;
            int row=current.row;
            int col=current.col;

            // col row, node.val

            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(row,new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            // now add to traversal row and col

            if(node.left!=null){
                q.add(new Tuple(node.left,col-1,row+1));
            }

            if(node.right!=null){
                q.add(new Tuple(node.right,col+1,row+1));
            }
        }

          List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {

               
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
    }
}