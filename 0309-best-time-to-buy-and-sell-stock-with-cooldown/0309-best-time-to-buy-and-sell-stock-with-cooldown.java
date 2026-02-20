class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 1) {
                    dp[index][canBuy] = Math.max(
                            -prices[index] + dp[index + 1][0],
                            dp[index + 1][1]);
                } else {
                    dp[index][canBuy] = Math.max(
                            prices[index] + dp[index + 2][1],
                            dp[index + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}

// class Solution {

//     public int f(int index,int canBuy,int[] prices,Integer[][] dp){
//         if(index>=prices.length) return 0;
//         if(dp[index][canBuy]!= null) return dp[index][canBuy];

//         if(canBuy==1){
//             return dp[index][canBuy] = Math.max(
//                 -prices[index]+f(index+1,0,prices,dp),
//                 f(index+1,1,prices,dp)
//             );
//         }
//         else{
//             return dp[index][canBuy] = Math.max(
//                 prices[index]+f(index+2,1,prices,dp),
//                 f(index+1,0,prices,dp)
//             );
//         }

//     }
//     public int maxProfit(int[] prices) {
//         Integer [][] dp = new Integer [prices.length][2];
//         return f(0,1,prices,dp);   
//     }
// }