class Solution {
    public int numberOfSpecialChars(String word) {
        Integer[] small = new Integer[26];
        Integer[] big = new Integer[26];
        int count = 0;
        for(int i =0;i<word.length();i++){
            if(word.charAt(i)>='a' && word.charAt(i)<='z'){
                small[(int)(word.charAt(i)-'a')]=i;
                
            }
            if(word.charAt(i)>='A' && word.charAt(i)<='Z' && big[(int)(word.charAt(i)-'A')]==null){
                big[(int)(word.charAt(i)-'A')]=i;
            }
        }
        for(int i =0;i<26;i++){
            if(small[i]!= null && big[i] != null && (small[i] < big[i])){
                count++;
            }
        }
    return count;
    }
}