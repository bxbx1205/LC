class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder ss=new StringBuilder();
        StringBuilder xx=new StringBuilder();
        StringBuilder yy=new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch==x){
                xx.append(ch);
            }
            else if(ch==y){
                yy.append(ch);
            }
            else{
                ss.append(ch);
            }
        }
        return yy.append(ss).append(xx).toString();
    }
}