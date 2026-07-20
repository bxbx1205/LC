class Solution {
    public int countHomogenous(String s) {
        long mod=1000000007;

        long sum=0;
        char prev='#';
        long cnt=0;
        for(char ch : s.toCharArray()){
            if(ch==prev){
                cnt++;
            }
            else{
                cnt=1;
                prev=ch;
            }

            sum=(sum+cnt)%mod;
        }
        return (int)sum;
    }
}