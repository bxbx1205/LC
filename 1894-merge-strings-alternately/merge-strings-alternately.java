class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int i=0;
        int j=0;

        String ans="";
        boolean turn = true;

        while(i<n && j<m){
            if(turn){
                ans+=word1.charAt(i);
                i++;
            }
            else{
                ans+=word2.charAt(j);
                j++;
            }
            turn = !turn;
        }

        while(i<n){
            ans+=word1.charAt(i++);
        }

        while(j<m){
            ans+=word2.charAt(j++);
        }

        return ans;
    }
}