class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int sum=0;
        int cnt=0;
        int i=0;
        int one=0;

        while(i<n){
            if(s.charAt(i)=='1'){
                one++;
                cnt=0;
                i++;
            }
            else{
                int start=i;
                while(start<n && s.charAt(start)=='0'){
                    cnt++;
                    start++;
                }
                ans.add(cnt);
                i=start;
            }
        }

        for(i=0;i<ans.size()-1;i++){
            sum=Math.max(ans.get(i)+ans.get(i+1),sum);
        }

        return sum+one;
    }
}