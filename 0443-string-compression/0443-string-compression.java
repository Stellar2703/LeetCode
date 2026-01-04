class Solution {
    public int compress(char[] chars) {
        int count = 1;
        int l = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count == 1) {
                    chars[l++] = chars[i - 1];
                } else {
                    chars[l++] = chars[i - 1];
                        String num = String.valueOf(count);
                        for (int j = 0; j < num.length(); j++) {
                            chars[l++] = num.charAt(j);
                    }
                    count = 1;
                }
            }
        }
        chars[l++] = chars[chars.length - 1];
        if (count > 1) {
            String num = String.valueOf(count);
            for (int j = 0; j < num.length(); j++) {
                chars[l++] = num.charAt(j);
            }
        }
        return l;
    }
}