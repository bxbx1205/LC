class Solution {
    public int jump(int[] nums) {
       int current=0;
       int max=0;
       int n = nums.length;
       if(n==1) return 0;
       int jump=0;


       for(int i =0;i<n-1;i++){
            max=Math.max(max,i+nums[i]);

            if(i==current){
                jump++;
                current=max;
            }
       } 

       return jump;
    }
}