package Array.Medium;

import java.util.Arrays;

public class RearrangeArrayElementsbySign {
    static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
    static int[] rearrangeArray(int[] nums) {
        int[] newArr = new int[nums.length];

        int pos = 0;
        int neg=1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                newArr[pos]=nums[i];
                pos+=2;
            }
            else {
                newArr[neg]=nums[i];
                neg+=2;
            }
        }

        return newArr;
    }
}
