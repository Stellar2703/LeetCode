class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1 ;
        while(i>=0){
            while(i>=0 && s.charAt(i)==' ')i--;
            int start = i;
            while(i>=0 && s.charAt(i)!=' ')i--;
            sb.append(s.substring(i+1,start+1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}