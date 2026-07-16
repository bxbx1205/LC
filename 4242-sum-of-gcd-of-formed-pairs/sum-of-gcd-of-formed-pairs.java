class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int[] gcdmax = new int[nums.length];
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            gcdmax[i] = gcd(nums[i], max);
        }

        Arrays.sort(gcdmax);

        long sum = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            sum += gcd(gcdmax[left++], gcdmax[right--]);
        }

        return sum;
    }
}