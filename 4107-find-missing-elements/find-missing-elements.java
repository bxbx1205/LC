class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int largest=Integer.MIN_VALUE;
        int smallest= Integer.MAX_VALUE;

        HashSet<Integer> map = new HashSet<>();

        for(int num:nums){
            largest=Math.max(largest,num);
            smallest=Math.min(smallest,num);
            map.add(num);
        }

        for(int i=smallest;i<largest;i++){
            if(!map.contains(i)){
                ans.add(i);
            }
        }


        return ans;
    }
}