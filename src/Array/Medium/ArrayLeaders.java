package Array.Medium;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println(leaders(arr));
    }

    static ArrayList<Integer> leaders(int nums[]) {
        ArrayList<Integer> answer = new ArrayList<>();

        int maxSoFar = nums[nums.length - 1];
        answer.add(maxSoFar);

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= maxSoFar) {
                maxSoFar = nums[i];
                answer.add(nums[i]);
            }
        }

        Collections.reverse(answer);
        return answer;
    }
}
