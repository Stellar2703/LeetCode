class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] small = new boolean[26];
        boolean[] big = new boolean[26];
        int count = 0;
        for(int i =0;i<word.length();i++){
            if(word.charAt(i)>='a' && word.charAt(i)<='z'){
                small[(int)(word.charAt(i)-'a')]=true;
                
            }
            if(word.charAt(i)>='A' && word.charAt(i)<='Z'){
                big[(int)(word.charAt(i)-'A')]=true;
            }
        }
        for(int i =0;i<26;i++){
            if(small[i]&&big[i]){
                count++;
            }
        }
    return count;
    }
}