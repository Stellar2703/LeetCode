class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        max_count = 0
        flipcount = 0
        l=0
        for r in range(len(nums)):
            if (nums[r]!=1):
                flipcount+=1
            while flipcount>k:
                if nums[l] == 0:
                    flipcount-=1
                l+=1
            max_count=max(max_count,r-l+1)

        return max_count