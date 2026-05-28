class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int idx = -1;
    }

    TrieNode root = new TrieNode();
    String[] words;

    // returns true if index a is better than index b
    boolean better(int a, int b) {

        if (b == -1) return true;

        // smaller length is better
        if (words[a].length() != words[b].length()) {
            return words[a].length() < words[b].length();
        }

        // if same length, earlier index is better
        return a < b;
    }

    void insert(String s, int index) {

        TrieNode node = root;

        // update root for empty suffix case
        if (better(index, node.idx)) {
            node.idx = index;
        }

        String rev = new StringBuilder(s).reverse().toString();

        for (char ch : rev.toCharArray()) {

            int c = ch - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            // store best index at every node
            if (better(index, node.idx)) {
                node.idx = index;
            }
        }
    }

    int search(String s) {

        TrieNode node = root;

        String rev = new StringBuilder(s).reverse().toString();

        for (char ch : rev.toCharArray()) {

            int c = ch - 'a';

            // stop if no more match
            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        words = wordsContainer;

        // build trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        // answer queries
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}