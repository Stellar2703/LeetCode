class Solution {
    public int myAtoi(String s) {

        if(s==null || s.length()==0){
            return 0;
        }
        int i = 0;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        if (i == s.length()) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        long res = 0;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int temp  = s.charAt(i) - '0';
            res = res*10+temp;

            if(res*sign>=Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            if(res*sign<=Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int)res*sign;
    }
}