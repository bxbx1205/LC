class Solution {
    public long maxProduct(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        long first = (long) nums[n - 1] * nums[n - 2];

        long second = (long) nums[0] * nums[1];

        long third = (long) nums[0] * nums[n - 1];

        long ans = Long.MIN_VALUE;

        ans = Math.max(ans, first * 100000L);
        ans = Math.max(ans, first * -100000L);

        ans = Math.max(ans, second * 100000L);
        ans = Math.max(ans, second * -100000L);

        ans = Math.max(ans, third * 100000L);
        ans = Math.max(ans, third * -100000L);

        return ans;
    }
}