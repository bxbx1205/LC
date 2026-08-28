class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        ArrayList<ArrayList<Integer>> revList = new ArrayList<>();

        for(int i=0;i<V;i++){
            revList.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        for(int i=0;i<V;i++){

            for(int j : graph[i]){
                revList.get(j).add(i);
                indegree[i]++; 
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i =0;i<V;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            int current = queue.poll();
            ans.add(current);

            for(int i : revList.get(current)){
                indegree[i]--;

                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}