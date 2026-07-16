class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int day=events[0][0];
        int i =0;
        int cnt=0; 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(!pq.isEmpty() || i<n){

            while(i<n && events[i][0]==day){
                pq.add(events[i][1]);
                i++;
            }

            if(!pq.isEmpty()){
                pq.remove();
                cnt++;
                
            }
            day++;
            while(!pq.isEmpty() && pq.peek()<day){
                pq.remove();
            }
        }

        return cnt;
    }
}