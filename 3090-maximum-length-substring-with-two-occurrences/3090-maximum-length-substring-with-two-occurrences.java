class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int l = 0;
        int ans = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int r = 0; r < n; r++) {
            mp.putIfAbsent(s.charAt(r), 0);

            mp.put(s.charAt(r), mp.get(s.charAt(r)) + 1);
            while (mp.get(s.charAt(r)) > 2) {
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}