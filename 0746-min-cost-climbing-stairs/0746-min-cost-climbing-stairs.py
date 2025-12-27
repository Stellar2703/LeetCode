class Solution:
    def f(self,arr,n,dp):
        if n<0:
            return 0
        if n==0:
            return arr[0]
        if n==1:
            return arr[1]
        if dp[n] != -1:
            return dp[n]
        dp[n] = arr[n] + min(self.f(arr,n-1,dp),self.f(arr,n-2,dp))
        return dp[n]
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        dp = [-1] * n
        return min(self.f(cost,n-1,dp),self.f(cost,n-2,dp))