class Solution {
    public int maxProduct(int n) {
        int max=n%10;
        n/=10;
        int Smax=Integer.MIN_VALUE;
       while(n>0){
            int current=n%10;
            n=n/10;
            if(current>max){
                Smax=max;
                max=current;
            }
            else if(current > Smax){
                Smax=current;
            }
       } 

       return Smax*max;
    }
}