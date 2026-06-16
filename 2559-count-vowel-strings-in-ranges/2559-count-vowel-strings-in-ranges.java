class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;

        int[] prefix = new int[n + 1];

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < n; i++) {
            String s = words[i];

            prefix[i + 1] = prefix[i];

            if (vowels.contains(s.charAt(0)) &&
                vowels.contains(s.charAt(s.length() - 1))) {
                prefix[i + 1]++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            ans[i] = prefix[r + 1] - prefix[l];
        }

        return ans;
    }
}