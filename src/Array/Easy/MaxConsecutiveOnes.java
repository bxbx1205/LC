package Array.Easy;

public class MaxConsecutiveOnes {
    static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));

    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int max =0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                counter++;
                if (counter>max) max=counter;
            } else if (nums[i]!=1) {
                counter = 0;
            }
        }
        return max;
    }
}
