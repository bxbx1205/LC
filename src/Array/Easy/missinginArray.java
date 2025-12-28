package Array.Easy;

public class missinginArray {
    static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        System.out.println(missingNum(arr));

    }
    static int missingNum(int[] arr){
        int n = arr.length;
        int expected = ((n+1)*(n))/2;

        int sum =0;
        for (int i = 0; i < arr.length-1 ; i++) {
            sum+=arr[i];
        }
        int answer = expected-sum;
        return answer;
    }
}
