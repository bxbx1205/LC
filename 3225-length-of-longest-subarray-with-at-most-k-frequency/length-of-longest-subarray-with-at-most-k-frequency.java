class Solution {
    // public boolean checker(HashMap<Integer,Integer> map,int k){
    //     for(int val : map.values()){
    //         if(val>k){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int left=0;
        int right=0;
        int max=0;
        
        HashMap<Integer,Integer> map = new HashMap<>();

        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            

            while(map.get(nums[right])>k){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }

            right++;
            max=Math.max(max,right-left);
        }

        return max;
    } 
}