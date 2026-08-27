class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inorder = new int[numCourses];

        for(int[] edge : prerequisites){
            inorder[edge[1]]++;
        }


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inorder[i] == 0) {
                queue.add(i);
            }
        }
        
        int cnt = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();

            cnt++;

            for(int[] edge:prerequisites){
                if(edge[0]==current){
                    int next=edge[1];
                    inorder[next]--;
                     if (inorder[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        return cnt==numCourses;
    }
}