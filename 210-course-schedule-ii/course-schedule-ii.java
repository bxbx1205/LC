class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];

        int[] inDegree = new int[numCourses];

        Arrays.fill(inDegree,0);

        for(int[] edge : prerequisites){
            inDegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int cnt=0;
        int index=0;

        for(int i = 0; i < numCourses; i++){ 
            if(inDegree[i] == 0){ 
                queue.offer(i); 
            } 
        } 
        // int cnt=0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            ans[index++]=current;
            cnt++;

            for(int[] edge: prerequisites){
                if(edge[1]==current){
                    int next= edge[0];
                    inDegree[next]--;

                    if(inDegree[next]==0){
                        queue.offer(next);
                    }
                }
            }
        }

        int[] zeros = new int[0];
        return cnt==numCourses?ans:zeros;
    }
}