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
    public void markParents(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                map.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                map.put(current.right, current);
                queue.offer(current.right);
            }
        }

        return;

    }

    public TreeNode findNode(TreeNode root, int target) {
        TreeNode ans = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.val == target) {
                return current;
            }

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return ans;
    }

    public int amountOfTime(TreeNode root, int start) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 0;

        //found node
        TreeNode target = findNode(root, start);

        // marking parents
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, parent);

        // now we trav radially
        int minute = -1;

        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Boolean> map = new HashMap<>();
        queue.offer(target);
        map.put(target, true);

        while (!queue.isEmpty()) {
            int n = queue.size();
            minute++;
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                //left
                if (map.get(current.left) == null && current.left != null) {
                    queue.offer(current.left);
                    map.put(current.left, true);
                }
                // right
                if (map.get(current.right) == null && current.right != null) {
                    queue.offer(current.right);
                    map.put(current.right, true);
                }
                // parent
                if (parent.get(current) != null && map.get(parent.get(current)) == null) {
                    queue.offer(parent.get(current));
                    map.put(parent.get(current), true);
                }
            }

        }

        return minute;
    }
}