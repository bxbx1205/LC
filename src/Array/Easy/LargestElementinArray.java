package Array.Easy;

public class LargestElementinArray {
    static void main(String[] args) {
        int arr[] = {1, 8, 7, 56, 90};
        System.out.println(largest(arr));
    }

    static int largest(int[] arr) {
        int largest = arr[0];
        if (arr.length == 0) return largest;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }
}
