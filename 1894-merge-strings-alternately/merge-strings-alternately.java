class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int i=0;
        int j=0;

        StringBuilder ans= new StringBuilder();
        boolean turn = true;

        while(i<n && j<m){
            if(turn){
                ans.append(word1.charAt(i));
                i++;
            }
            else{
                ans.append(word2.charAt(j));
                j++;
            }
            turn = !turn;
        }

        while(i<n){
            ans.append(word1.charAt(i++));
        }

        while(j<m){
            ans.append(word2.charAt(j++));
        }

        return ans.toString();
    }
}