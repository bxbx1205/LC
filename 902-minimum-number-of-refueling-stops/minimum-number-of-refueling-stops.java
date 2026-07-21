class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Arrays.sort(stations,(a,b)->{
        //     return a[1]-b[1];
        // });

        int n =stations.length;
        int current=startFuel;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });

        int cnt=0;
        int i=0;
        
        while(current<target){
            while(i<n && stations[i][0]<=current){
                pq.offer(stations[i][1]);
                i++;
            }

            if(pq.isEmpty()) return -1;

            int curr=pq.poll();
            current+=curr;
            cnt++;
        } 

        return cnt;
    }
}