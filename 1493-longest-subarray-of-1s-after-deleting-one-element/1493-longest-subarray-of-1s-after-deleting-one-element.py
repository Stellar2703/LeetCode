class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        ans = 0
        l = 0 
        cnt = 0
        for r in range(len(nums)):
            if nums[r] == 0:
                cnt+=1
            while(cnt>1):
                if(nums[l]==0):
                    cnt-=1
                l+=1
            ans=max(ans,r-l)
        return ans
