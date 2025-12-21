class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int l = 0, maxlen = 0;

        for (int r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);

            if (mp.containsKey(curr) && mp.get(curr) >= l) {
                l = mp.get(curr) + 1;
            }

            mp.put(curr, r);  // ALWAYS update index
            maxlen = Math.max(maxlen, r - l + 1); // ALWAYS update
        }

        return maxlen;
    }
}
