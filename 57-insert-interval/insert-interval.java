class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        for(int i =0;i<n;i++){

            if(intervals[i][1]<start){
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }
            else if(end<intervals[i][0]){
                ans.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
            else{
                start=Math.min(start,intervals[i][0]);
                end=Math.max(end,intervals[i][1]);
            }
        }
        ans.add(new int []{start,end});

        int[][] matrix= ans.toArray(new int[0][]);

        return matrix;

    }
}