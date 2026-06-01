class Solution {
    private int f(int index, int[][] items, int budget, int[] free, int taken, int[][][] dp) {

        if (budget < 0)
            return -1000000;
        if (index == items.length)
            return 0;
        if (dp[index][budget][taken] != -1)
            return dp[index][budget][taken];

        int pick = 0;
        if (taken == 1) {
            pick = 1 + f(index, items, budget - items[index][1], free, 1, dp);
        } else {
            pick = 1 + free[index] + f(index, items, budget - items[index][1], free, 1, dp);
        }
        int not_pick = f(index + 1, items, budget, free, 0, dp);

        return dp[index][budget][taken] = Math.max(pick, not_pick);

    }

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[][][] dp = new int[n][budget+1][2];
        for (int i = 0; i < n; i++) {
            for (int b = 0; b <= budget; b++) {
                dp[i][b][0] = -1;
                dp[i][b][1] = -1;
            }
        }

        int[] factor = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i && items[j][0] % items[i][0] == 0) {
                    factor[i]++;
                }
            }
        }
        return f(0, items, budget, factor, 0, dp);

    }
}