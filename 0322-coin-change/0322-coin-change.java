class Solution {
    public int f(int[] coins,int index,int target,int[][] dp){
        if(target == 0) return 0;
        if(index<0) return 10000000;
        if(dp[index][target]!=-1) return dp[index][target];
        int notpick = f(coins,index-1,target,dp);
        int pick = 10000000;
        if(coins[index]<=target){
            pick = 1+f(coins ,index,target-coins[index],dp);
        }
        return dp[index][target] = Math.min(pick,notpick);
    }
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length][amount+1];
         for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = f(coins,coins.length-1,amount,dp);
        return ans >= 10000000 ? -1 : ans;
    }
}