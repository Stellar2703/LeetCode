class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int fir = 0;
        int sec = 0;
        while(fir<str1.length() && sec<str2.length()){
            if(str1.charAt(fir)==str2.charAt(sec)|| 
            (char) ('a' + (str1.charAt(fir) - 'a' + 1) % 26)==str2.charAt(sec)){
                fir++;
                sec++;
            }
            else{
                fir++;
            }
        }
        if(sec==str2.length()) return true;
        return false;
    }
}