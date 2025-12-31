package Array.Medium;

public class mooreVotingAlgorithm {
    static void main(String[] args) {
        int[] arr = {3,2,3};
        System.out.println(majorityElement(arr));
    }
        static int majorityElement(int[] nums){
            int majority=nums[0];
            int votes=1;
            for (int i = 1; i < nums.length; i++) {

                if (votes==0){
                    majority=nums[i];
                }

                if (nums[i]==majority){
                    votes++;
                } else{
                    votes--;
                }


            }
        return majority;
        }

}
