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
    public void markParents(TreeNode root,HashMap<TreeNode,TreeNode> parents){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();

            if(current.left!=null){
                queue.offer(current.left);
                parents.put(current.left,current);
            }

            if(current.right!=null){
                queue.offer(current.right);
                parents.put(current.right,current);
            }

        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // parents mil gye
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        markParents(root,parent);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int currentLevel=0;
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        visited.put(target, true);

        while(!queue.isEmpty()){
           

            if(currentLevel==k) break;
            currentLevel++;

            int n = queue.size();

            for(int i =0;i<n;i++){
                TreeNode current=queue.poll();
                // left right parents traverse kar
                if(current.left!=null && visited.get(current.left)==null){
                    queue.offer(current.left);
                    visited.put(current.left,true);
                }

                if(current.right!=null && visited.get(current.right)==null){
                    queue.offer(current.right);
                    visited.put(current.right,true);
                }

                if(parent.get(current)!=null && visited.get(parent.get(current))==null){
                    queue.offer(parent.get(current));
                    visited.put(parent.get(current),true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }

        return ans;
    }
}