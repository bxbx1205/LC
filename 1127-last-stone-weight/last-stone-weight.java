class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num:stones){
            pq.add(num);
        }

        while(pq.size()>1){

            int largest=pq.remove();
            int slargest=pq.remove();
            int calc=largest-slargest;

            if(calc!=0){
                pq.add(calc);
            }
        }

        if(pq.size()==1){
            return pq.remove();
        }
        else{
            return 0;
        }
        
    }
}