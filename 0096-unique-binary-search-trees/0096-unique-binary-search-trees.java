class Solution {
    private int f(int n,int[] dp){
        if(n <= 1) return 1;
        if(dp[n]!=-1) return dp[n];
        int ans = 0;
        for(int i=1;i<=n;i++){
            ans+= f(i-1,dp)*f(n-i,dp);
        }
        dp[n] = ans;
        return ans;
    }
    public int numTrees(int n) {
        int ans=0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(n,dp);
    }
}