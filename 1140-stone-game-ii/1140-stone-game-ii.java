import java.util.*;

class Solution {

    int n;
    int[][][] dp;

    public int f(boolean alice, int index, int M, int[] piles) {

        if (index >= n) {
            return 0;
        }

        int person = alice ? 1 : 0;

        // Already calculated
        if (dp[person][index][M] != -1) {
            return dp[person][index][M];
        }

        int res = alice ? -1 : Integer.MAX_VALUE;

        int stones = 0;

        for (int i = 1; i <= 2 * M && index + i <= n; i++) {

            // Take i piles
            stones += piles[index + i - 1];

            int newM = Math.max(M, i);

            if (alice) {

                // Alice wants to MAXIMIZE her score
                res = Math.max(
                    res,
                    stones + f(false, index + i, newM, piles)
                );

            } else {

                // Bob wants to MINIMIZE Alice's score
                res = Math.min(
                    res,
                    f(true, index + i, newM, piles)
                );
            }
        }

        return dp[person][index][M] = res;
    }

    public int stoneGameII(int[] piles) {

        n = piles.length;

        dp = new int[2][n][n + 1];

        for (int person = 0; person < 2; person++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[person][i], -1);
            }
        }

        return f(true, 0, 1, piles);
    }
}
