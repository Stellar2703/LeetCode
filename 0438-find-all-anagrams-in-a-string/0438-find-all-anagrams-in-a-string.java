class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;

        Map<Character, Integer> req = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();

        // build frequency map of p
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            req.put(c, req.getOrDefault(c, 0) + 1);
        }

        int required = req.size();
        int formed = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            win.put(c, win.getOrDefault(c, 0) + 1);

            if (req.containsKey(c) && win.get(c).intValue() == req.get(c).intValue()) {
                formed++;
            }

            while (r - l + 1 > p.length()) {
                char left = s.charAt(l);
                if (req.containsKey(left) &&
                    win.get(left).intValue() == req.get(left).intValue()) {
                    formed--;
                }
                win.put(left, win.get(left) - 1);
                l++;
            }

            if (formed == required && r - l + 1 == p.length()) {
                ans.add(l);
            }
        }

        return ans;
    }
}
