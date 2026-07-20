class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;
        int[][] arr = new int[n][3];

        for(int i =0;i<n;i++){
            arr[i][0]=i;
            arr[i][1]=tasks[i][0];
            arr[i][2]=tasks[i][1];
        }

        Arrays.sort(arr,(a,b)->{
            if(a[1]==b[1]){
                return a[2]-b[2];
            }
            return a[1]-b[1];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                if(a[2]==b[2]){
                    return a[0]-b[0];
                }
                return a[2]-b[2];
            }
        );

        int arrindex=0;
        int[] ans = new int[n];
        int time=0;
        int ansIdx=0;

        while(arrindex<n || !pq.isEmpty()){

            if(pq.isEmpty() && arr[arrindex][1]>time){
                time=arr[arrindex][1];
            }

            while (arrindex < n && arr[arrindex][1] <= time) {
                pq.add(arr[arrindex]);
                arrindex++;
            }

            int[] current=pq.poll();
            ans[ansIdx++] = current[0];
            time += current[2];
        }

        return ans;
    }
}