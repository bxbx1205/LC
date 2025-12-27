package Array.Easy;

public class CheckifArrayIsSortedandRotated {
    static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(check(arr));
    }

    static boolean check(int[] nums){
        int count =0;
        for (int i = 0; i < nums.length-1 ; i++) {
            if (nums[i]>nums[i+1] % nums.length) count++;
        }
        return count <=1;
    }
}
