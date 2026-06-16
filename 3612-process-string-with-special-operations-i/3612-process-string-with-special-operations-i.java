class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='a' && c<='z') sb.append(c);
            if(sb.length()>0 && c=='*')sb.setLength(sb.length()-1);
            if(c=='#'){
                String temp = sb.toString();
                sb.append(temp);
            }
            if(c=='%')sb.reverse();
        }
        return sb.toString();
    }
}