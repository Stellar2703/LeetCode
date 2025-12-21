class Solution {
    public int numberOfSubstrings(String s) {
        int n =s.length();
        int [] ls = {-1,-1,-1};
        int ans =0;
        for (int i =0;i<n;i++){
            char c = s.charAt(i);
            ls[c-'a']=i;
            if(ls[0]!=-1 && ls[1]!=-1 && ls[2]!=-1){
                ans+= 1+Math.min(ls[0],Math.min(ls[1],ls[2]));
            }
        }
            return ans;
    }
}