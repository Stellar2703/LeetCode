class Solution {
    public int minimumLength(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                while(l<r && s.charAt(l+1)==s.charAt(l))l++;
                while(l<r && s.charAt(r-1)==s.charAt(r))r--;
                l++;
                r--;
            }
            else{
                break;
            }
        }
        if(r<l) return 0;
        return r-l+1;
    }
}