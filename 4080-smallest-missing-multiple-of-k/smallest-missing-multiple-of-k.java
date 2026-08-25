class Solution {
    public int missingMultiple(int[] nums, int k) {
        // if(nums.length==1){
        //     return nums[0]*2;
        // }
        HashSet<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int incK=k;

        int ans=0;

        while(true){
            if(!set.contains(incK)){
                ans = incK;
                break;
            }

            incK+=k;
        }
        return ans;
    }
}