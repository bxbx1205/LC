class Solution {
    public int maximumCount(int[] nums) {
        int pcnt = 0;
        int ncnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                ncnt++;
            if (nums[i] > 0)
                pcnt++;
        }

        return Math.max(ncnt, pcnt);
    }
}