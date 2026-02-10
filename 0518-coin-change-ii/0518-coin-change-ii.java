class Solution {
    public int f(int[] nums, int index, int amount,int [][] dp){
        if(amount == 0 ) return 1;
        if(index<0) return 0;
        if(index == 0) return amount % nums[0] == 0 ? 1 : 0;
        if (dp[index][amount]!=-1) return dp[index][amount];


        int not_pick = f(nums,index-1,amount,dp);
        int pick = 0;
        if(nums[index]<=amount){
            pick = f(nums,index,amount-nums[index],dp);
        }
        return dp[index][amount] = pick+not_pick;

    }
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(coins,coins.length-1,amount,dp);
    }
}