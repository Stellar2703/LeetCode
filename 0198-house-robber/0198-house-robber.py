class Solution:
    def rob(self, nums: List[int]) -> int:

        ### RECURSIVE APPROACH ###
        # def rob(n,nums):
        #     if n==0: return nums[0]
        #     if n<=-1: return 0
        #     pick = nums[n]+rob(n-2,nums)
        #     notpick = rob(n-1,nums)
        #     return max(pick,notpick)
        # n = len(nums)
        # ans = rob(n-1,nums)
        # return ans



        #### Memoization #####
        # def f(index,nums,dp):
        #     if index == 0 : return nums[0]
        #     if index<0 : return 0
        #     if dp[index] != -1: return dp[index]
        #     pick = nums[index] + f(index-2,nums,dp)
        #     not_pick = f(index-1,nums,dp)
        #     dp[index] = max(pick,not_pick)
        #     return dp[index]
        # n = len(nums)
        # dp = [-1] * (len(nums))
        # ans = f(n-1,nums,dp)
        # return ans


        ### Tabulation ###
        # n = len(nums)
        # dp = [-1] * n
        # dp[0]  = nums[0]

        # for i in range(1,n):
        #     not_pick = dp[i-1]
        #     pick = nums[i]
        #     if i>1:
        #         pick+=dp[i-2]
        #     dp[i] = max(pick,not_pick)
        # return dp[n-1]



        ### Space Optimization ###

        n = len(nums)
        
        prev  = nums[0]
        prev2 = 0

        for i in range(1,n):
            not_pick = prev
            pick = nums[i]
            if i>1:
                pick+=prev2
            curr = max(pick,not_pick)
            prev2 = prev
            prev = curr
        return prev