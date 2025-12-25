package Recursion;

public class oneTOn {
    static void main(String[] args) {
        printTillN(5);
    }

    static void printTillN(int N) {
        if(N==0) return;
        printTillN(N-1);
        System.out.println(N);


    }
}
