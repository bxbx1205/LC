class Solution {
    public int gcd(int first ,int second){

        for(int i = first;i>=0;i--){
            if(first%i==0 && second%i==0){
                return i;
            }
        }
        return 0;
    }
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < n; i++) {
            sumOdd += 2 * i + 1;
        }

        for (int i = 1; i <= n; i++) {
            sumEven += 2 * i;
        }
        return gcd(sumOdd,sumEven);
    }
}