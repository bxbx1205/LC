class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            else{
                return a[0]-b[0];
            }
        });


        int n = intervals.length;

        int cnt=1;
        int[] last =intervals[0];

        for(int i=1;i<n;i++){
            if (last[0] <= intervals[i][0] && last[1] >= intervals[i][1]) {
                continue; 
            }
            else{
                cnt++;
                last=intervals[i];
            }
        }

        return cnt;
    }
}