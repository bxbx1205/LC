class Solution {
    public int missingInteger(int[] nums) {
        if(nums.length==1){
            return nums[0]+1;
        }
        HashSet<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }
        int n = nums.length;
        
        int curr=0;
        int i=0;
        int j=1;
        curr+=nums[0];
        int ans=0;
        while(j<n && i<n){
            if(nums[j]==nums[j-1]+1){
                curr+=nums[j];
                j++;
                int tempcurr=curr;
                while(true){
                    if(set.contains(tempcurr)){
                        tempcurr++;
                    }
                    else{
                        ans=tempcurr;
                        break;
                    }
                }
            }
            else{
                break;
            }
        }

         if(j==1){ 
            int tempcurr=curr;
            while(set.contains(tempcurr)){
                tempcurr++;
            }
            ans=tempcurr;
        }
        return ans;
    }
}