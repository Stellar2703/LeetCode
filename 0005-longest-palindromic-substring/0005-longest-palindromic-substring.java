class Solution {
    public String longestPalindrome(String s) {
        int l=0;
        int r=0;
        int max = 0;
        int start=0;
        int stop =0;
        int count =1;
        for(int i =0;i<s.length();i++){
            count =1;
            l = i-1;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                count +=2;
            }
            if(count>max){
                max = count;
                start = l+1;
                stop = r-1;
            }
            l = i;
            r=i+1;
            count =0;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                count +=2;
            }
            if(count>max){
                max = count;
                start = l+1;
                stop = r-1;
            }
        }
        return s.substring(start,stop+1);
    }
}