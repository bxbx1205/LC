class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index=0;
        int children=0;

        while(index<s.length && children<g.length){

            if(s[index]>=g[children]){
                children++;
            }

            index++;
        }

        return children;
    }
}