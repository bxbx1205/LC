class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {
            int f1 = Integer.parseInt(a[1]);
            int f2 = Integer.parseInt(b[1]);

            if (f1 == f2) {
                return b[0].compareTo(a[0]); 
            }

            return f1 - f2;
        });

        for (String word : map.keySet()) {
            pq.offer(new String[]{word, String.valueOf(map.get(word))});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll()[0]);
        }

        Collections.reverse(ans);

        return ans;
    }
}