class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i =0;i<n;i++){
            int index=s.charAt(i)-'a';
            last[index]=Math.max(last[index],i);
        }
        
        for(int i=0;i<n;i++){
            char currentChar=s.charAt(i);
            if(seen[currentChar-'a']==true){
                continue;
            }

            while(!st.isEmpty() && st.peek()>currentChar && last[st.peek()-'a']>i){
                seen[st.peek()-'a']=false;
                st.pop();
            }

            st.push(currentChar);
            seen[currentChar-'a']=true;
        }

        StringBuilder str= new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }

        str.reverse();

        return str.toString();
    }
}