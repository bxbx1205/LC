package Array.Easy;

import java.util.Arrays;

public class RemoveElement {
    static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val =2;
        System.out.println(removeElement(arr,val));
    }

    static int removeElement(int[] nums, int val) {


        int index=0;
        int n = nums.length;

        for (int i = 0; i < nums.length ; i++) {
            if (nums[i]!=val){
                nums[index]=nums[i];
                index++;
            }
        }

        int R = index;


        while (index<nums.length){
            nums[index]=2;
            index++;
        }

        return R;
    }
}
