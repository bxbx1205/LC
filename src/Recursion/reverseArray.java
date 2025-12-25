package Recursion;

import java.util.Arrays;

public class reverseArray {
    static void main(String[] args) {
        int arr[]={1,2,3,4,6};

        reverseArray(arr,0);
        System.out.println(Arrays.toString(arr));
    }
    static void reverseArray(int arr[],int n) {
        if(n>=((arr.length)/2)) return;
        int index = arr.length-1;

        int temp = arr[index-n];
        arr[index-n] = arr[n];
        arr[n]=temp;

        reverseArray(arr, n+1);


    }
}
