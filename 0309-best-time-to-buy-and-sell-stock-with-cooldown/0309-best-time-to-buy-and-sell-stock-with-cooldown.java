class Solution {

    public int f(int index,int canBuy,int[] prices,Integer[][] dp){
        if(index>=prices.length) return 0;
        if(dp[index][canBuy]!= null) return dp[index][canBuy];

        if(canBuy==1){
            return dp[index][canBuy] = Math.max(
                -prices[index]+f(index+1,0,prices,dp),
                f(index+1,1,prices,dp)
            );
        }
        else{
            return dp[index][canBuy] = Math.max(
                prices[index]+f(index+2,1,prices,dp),
                f(index+1,0,prices,dp)
            );
        }

    }
    public int maxProfit(int[] prices) {
        Integer [][] dp = new Integer [prices.length][2];
        return f(0,1,prices,dp);   
    }
}