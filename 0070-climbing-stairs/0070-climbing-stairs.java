class Solution {
    public int climbStairs(int n) {
        if(n<=1) return 1;
        int prev1 = 1;
        int prev2 = 1;
        int curr=0;
        for(int i=2;i<n+1;i++){
            curr = prev1+prev2;
            prev1 = prev2;
            prev2= curr;
        }
        return prev2;
    }
}



// class Solution {
//     public int climbStairs(int n) {
//         int [] dp = new int[n+1];
//         dp[0] = 1;
//         dp[1] = 1;
//         for(int i=2;i<n+1;i++){
//             dp[i] = dp[i-1]+dp[i-2];
//         }
//         return dp[n];
//     }
// }




// class Solution {
//     public int f(int n,int[] dp){
//         if(n==0) return 1;
//         if(n<0) return 0;
//         if(dp[n]!=-1) return dp[n];
//         int pick = f(n-1,dp);
//         int not_pick = f(n-2,dp);
//         return dp[n] = pick+not_pick;
//     }
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         return f(n,dp);
//     }
// }