class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0]=0;
        dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            dp [i][1] = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
            dp[i][0] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
        }
        return dp[0][1];
    }
}

// class Solution {
//     public int f(int[] prices, int i, int canBuy, Integer[][] dp) {
//         if (i == prices.length) return 0;

//         if (dp[i][canBuy] != null) return dp[i][canBuy];

//         if (canBuy == 1) {
//             int buy = -prices[i] + f(prices, i + 1, 0, dp);
//             int skip = f(prices, i + 1, 1, dp);
//             return dp[i][canBuy] = Math.max(buy, skip);
//         } else {
//             int sell = prices[i] + f(prices, i + 1, 1, dp);
//             int hold = f(prices, i + 1, 0, dp);
//             return dp[i][canBuy] = Math.max(sell, hold);
//         }
//     }

//     public int maxProfit(int[] prices) {
//         Integer[][] dp = new Integer[prices.length][2];
//         return f(prices, 0, 1, dp);
//     }
// }
