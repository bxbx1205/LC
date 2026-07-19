class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        int n = heights.length;

        for(int i=0;i<n;i++){
            expected[i]=heights[i];
        }

        Arrays.sort(expected);
        int cnt=0;

        for(int i=0;i<n;i++){
            if(expected[i]!=heights[i]) cnt++;
        }

        return cnt;
    }
}