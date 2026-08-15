class Solution {
    public void bfs(int[][] isConnected,boolean[] visited, int i){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(i);
        visited[i]=true;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int j=0;j<isConnected.length;j++){
                if(!visited[j] && isConnected[current][j]==1){
                    queue.offer(j);
                    visited[j]=true;
                }
            }
        }
        return;
    }

    public int findCircleNum(int[][] isConnected) {
        int cnt=0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                cnt++;
                bfs(isConnected,visited,i);
            }
        }

        return cnt;    
    }
}