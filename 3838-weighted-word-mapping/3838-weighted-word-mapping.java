class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder s = new StringBuilder();

        for (String str : words) {
            int count = 0;

            for (char c : str.toCharArray()) {
                count += weights[c - 'a'];
            }

            count %= 26;
            s.append((char) ('z'-count));
        }

        return s.toString();
    }
}