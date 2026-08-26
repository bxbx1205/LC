class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        int[] outDegree = new int[n];

        List<Integer>[] reverse = new ArrayList[n];

        for(int i = 0; i < n; i++){
            reverse[i] = new ArrayList<>();
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){

            outDegree[i] = graph[i].length;

            for(int neighbour : graph[i]){
                reverse[neighbour].add(i);
            }

            if(outDegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()){

            int node = queue.poll();

            ans.add(node);

            for(int prev : reverse[node]){

                outDegree[prev]--;

                if(outDegree[prev] == 0){
                    queue.offer(prev);
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }
}