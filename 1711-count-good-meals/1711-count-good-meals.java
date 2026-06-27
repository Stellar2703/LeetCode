class Solution {
    public int countPairs(int[] deliciousness) {

        final int MOD = 1_000_000_007;

        HashMap<Integer, Integer> freq = new HashMap<>();

        long ans = 0;

        for (int x : deliciousness) {

            for (int power = 1; power <= (1 << 21); power <<= 1) {

                ans += freq.getOrDefault(power - x, 0);

                ans %= MOD;
            }

            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        return (int) ans;
    }
}