class Solution {
    public char processStr(String s, long k) {
        long length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
                length++;
            if (s.length() > 0 && c == '*')
                length = Math.max(0, length - 1);
            if (c == '#')
                length *= 2;
        }
        if (k >= length)
            return '.';
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                length--;
                if (length == k)
                    return c;
            }
            if (s.length() > 0 && c == '*')
                length++;
            if (c == '#'){
                long half = length/2;
                if(k>=half) k-=half;
                length=half;
            }
            if (c == '%')
                k = length - 1 - k;
        }
        return '.';
    }
}