class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time=0;

        for(int[] course:courses){
            
                if(course[0]+time<=course[1]){
                    time+=course[0];
                    pq.offer(course[0]);
                }
            else{
                if(!pq.isEmpty() && pq.peek()>course[0]){
                    time-=pq.poll();
                    // pq.remove();
                    time+=course[0];
                    pq.offer(course[0]);
                }
            }
        } 

        return pq.size();
    }
}