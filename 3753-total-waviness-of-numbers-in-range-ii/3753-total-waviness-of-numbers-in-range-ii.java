

class Solution {

    private String digits;
    private long[][][][][][] memo;
    private boolean[][][][][][] seen;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        digits = Long.toString(x);

        int n = digits.length();

        memo = new long[n + 1][2][2][11][11][2];
        seen = new boolean[n + 1][2][2][11][11][2];

        long[] res = dfs(0, 1, 0, 10, 10);
        return res[1];
    }

    private long[] dfs(int pos,
                       int tight,
                       int started,
                       int prev2,
                       int prev1) {

        if (pos == digits.length()) {
            return new long[]{1L, 0L}; // count, waviness
        }

        if (seen[pos][tight][started][prev2][prev1][0]) {
            return new long[]{
                memo[pos][tight][started][prev2][prev1][0],
                memo[pos][tight][started][prev2][prev1][1]
            };
        }

        long totalCount = 0;
        long totalWaviness = 0;

        int limit = tight == 1 ? digits.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {

            int nextTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0) {

                if (d == 0) {
                    long[] nxt = dfs(
                        pos + 1,
                        nextTight,
                        0,
                        10,
                        10
                    );

                    totalCount += nxt[0];
                    totalWaviness += nxt[1];

                } else {

                    long[] nxt = dfs(
                        pos + 1,
                        nextTight,
                        1,
                        10,
                        d
                    );

                    totalCount += nxt[0];
                    totalWaviness += nxt[1];
                }

            } else {

                int add = 0;

                if (prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }

                long[] nxt = dfs(
                    pos + 1,
                    nextTight,
                    1,
                    prev1,
                    d
                );

                totalCount += nxt[0];
                totalWaviness += nxt[1] + (long) add * nxt[0];
            }
        }

        seen[pos][tight][started][prev2][prev1][0] = true;

        memo[pos][tight][started][prev2][prev1][0] = totalCount;
        memo[pos][tight][started][prev2][prev1][1] = totalWaviness;

        return new long[]{totalCount, totalWaviness};
    }
}