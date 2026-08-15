class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor=0;
        int length=0;
        int i=0;
        int zeroCnt=0;
        for(i=0;i<n;i++){
            if(nums[i]==0){
                zeroCnt++;
            }
            xor^=nums[i];
            if(xor!=0){
                length=i;
            }
        }
        if(zeroCnt==n){
            return 0;
        }
        if(xor!=0){
            return n;
        }
        return n-1;
    }
}