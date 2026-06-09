class Solution {

    private boolean isPalin(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }

    private void f(int start, String s,
                   List<String> temp,
                   List<List<String>> ans) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            String part = s.substring(start, end + 1);

            if (isPalin(part)) {
                temp.add(part);

                f(end + 1, s, temp, ans);

                temp.remove(temp.size() - 1); // backtrack
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        f(0, s, new ArrayList<>(), ans);

        return ans;
    }
}