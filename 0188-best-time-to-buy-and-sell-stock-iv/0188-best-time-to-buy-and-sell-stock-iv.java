class Solution {
    public int f(int index,int[] prices,int canBuy,int limit,Integer[][][] dp){
        if(index>=prices.length) return 0;
        if(limit==0) return 0;
        if(dp[index][canBuy][limit]!=null) return dp[index][canBuy][limit];
        if(canBuy==1){
            return dp[index][canBuy][limit] = Math.max(
                -prices[index]+f(index+1,prices,0,limit,dp)
            ,f(index+1,prices,1,limit,dp)
            );
        }else{
            return dp[index][canBuy][limit] =  Math.max(prices[index]+f(index+1,prices,1,limit-1,dp),
            f(index+1,prices,0,limit,dp));
        }
    }
    public int maxProfit(int k, int[] prices) {
         int n = prices.length;
        Integer[][][] dp = new Integer [n][2][k+1];
        return f(0,prices,1,k,dp);
    }
}