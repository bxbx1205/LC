package Array.Easy;

import java.util.Arrays;

public class rotateArrayN {
    static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k = 2;

        System.out.println(Arrays.toString(rotate(arr,k)));
    }
    static int[] rotate(int[] nums, int k){
         k = k% nums.length; //very imp step overflow ko handle


        reverse(nums,0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k , nums.length-1);


        return nums;
    }

     static private void reverse(int[] nums, int start, int end){
        while (start<end){
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }


}
