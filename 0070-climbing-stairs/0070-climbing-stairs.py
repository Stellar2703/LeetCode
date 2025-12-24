class Solution:
    def climbStairs(self, n: int) -> int:
        def f(n,dp):
            if (n<=2):
                return n
            if (dp[n]!=-1): 
                return dp[n]
            dp[n] = f(n-1,dp) + f(n-2,dp)
            return dp[n]
    
        dp = [-1] * (n+1)
        ans = f(n,dp)
        return ans