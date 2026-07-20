class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[1] == b[1]) {
                        return a[2] - b[2];
                    }
                    return a[1] - b[1];
                });

        int n = tasks.length;

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        
        // for(int i=0;i<n;i++){
        //     pq.add(new int[]{i,tasks[i][0],tasks[i][1]});
        // }

        int[] ans= new int[n];
        int index=0;
        int time=0;
        int arrindex=0;
        int ansIdx=0;

        while(arrindex<n || !pq.isEmpty()){
             if (pq.isEmpty() && time < arr[arrindex][0]) {
                time = arr[arrindex][0];
            }

            while (arrindex < n && arr[arrindex][0] <= time) {
                pq.add(arr[arrindex]);
                arrindex++;
            }

            int[] current = pq.poll();
            ans[ansIdx++] = current[2];
            time += current[1];
        }

        

    return ans;
}
}