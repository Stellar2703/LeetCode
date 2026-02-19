class Solution {
    public int f(int index,int[] prices,int canBuy,int limit,Integer[][] dp){
        if(index>=prices.length) return 0;
        if(limit==0) return 0;
        if(dp[index][canBuy]!=null) return dp[index][canBuy];
        if(canBuy==1){
            return dp[index][canBuy] = Math.max(
                -prices[index]+f(index+1,prices,0,limit,dp)
            ,f(index+1,prices,1,limit,dp)
            );
        }else{
            return dp[index][canBuy] =  Math.max(prices[index]+f(index+1,prices,1,limit-1,dp),
            f(index+1,prices,0,limit,dp));
        }

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer [n][2];
        return f(0,prices,1,2,dp);
    }

}