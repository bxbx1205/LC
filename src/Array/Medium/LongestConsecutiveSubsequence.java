package Array.Medium;

import java.util.HashMap;

public class LongestConsecutiveSubsequence {
    static void main(String[] args) {
        int[] arr = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(longestConsecutive(arr));
    }
    static int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],1 );
        }

        int maxCount=0;

        for (int i = 0; i < nums.length; i++) {

            int count=1;
            int current=nums[i];

            while (map.containsKey(current+1)){
                current+=1;
                count++;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }


    return maxCount ;
    }
}
