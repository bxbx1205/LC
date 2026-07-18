class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int n = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {

            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                ans.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }

            
        }
        ans.add(new int[]{start,end});
        int[][] matrix = ans.toArray(new int[0][]);
        return matrix;
    }
}