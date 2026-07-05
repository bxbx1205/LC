class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(char ch :tasks){
            map[ch-'A']++;
        }

        for(int i=0;i<26;i++){
            if(map[i]>0){
                pq.offer(map[i]);
            }
        }
        int time =0;
        while(!pq.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();

            for(int i=1;i<=n+1;i++){

                if(!pq.isEmpty()){
                    int frequency=pq.poll();
                    // pq.poll();
                    frequency--;
                    list.add(frequency);
                }

            }

            for(int freq:list){
                if(freq>0) pq.add(freq);
            }

            if (pq.isEmpty()) {
                time += list.size();
            }
        
            else {
                time += n + 1;
            }
        }

        
         return time;

    }   
}