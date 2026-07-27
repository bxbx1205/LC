class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sMax=Integer.MIN_VALUE;

        for(int num:nums){
            if(num>max){
                sMax=max;
                max=num;
            }
            else if(num>sMax){
                sMax=num;
            }
        }

        return (max-1)*(sMax-1);
    }
}