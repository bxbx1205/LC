class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : gifts) {
            pq.add(num);
        }

        while (k > 0) {
            int num = pq.remove();
            int put = (int) Math.floor(Math.sqrt(num));

            pq.add(put);

            k--;
        }

        long sum = 0;

        while (!pq.isEmpty()) {
            sum += pq.remove();
        }

        return sum;
    }
}