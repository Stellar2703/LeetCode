class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n+1][2][3];
        for(int i = n-1;i>=0;i--){
            for(int canBuy = 0;canBuy<=1;canBuy++){
                for(int limit=1;limit<=2;limit++){
                    if(canBuy==1){
                        dp[i][canBuy][limit] = Math.max
                        (-prices[i]+dp[i+1][0][limit],dp[i+1][1][limit]);
                    }
                    else{
                        dp[i][canBuy][limit] = Math.max(
                            prices[i]+dp[i+1][1][limit-1],dp[i+1][0][limit]
                        );
                    }
                }
            }
        }
        return dp[0][1][2];
        
    }
}



// class Solution {
//     public int f(int i,int[] prices,int canBuy,int limit,Integer[][][] dp){
//         if(i>=prices.length) return 0;
//         if(limit==0) return 0;
//         if(dp[i][canBuy][limit]!=null) return dp[i][canBuy][limit];
//         if(canBuy==1){
//             return dp[i][canBuy][limit] = Math.max(
//                 -prices[i]+f(i+1,prices,0,limit,dp)
//             ,f(i+1,prices,1,limit,dp)
//             );
//         }else{
//             return dp[i][canBuy][limit] =  Math.max(prices[i]+f(i+1,prices,1,limit-1,dp),
//             f(i+1,prices,0,limit,dp));
//         }
//     }
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         Integer[][][] dp = new Integer [n][2][3];
//         return f(0,prices,1,2,dp);
//     }
// }