class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        count = 0
        left = 0
        flipcount=0
        for right in range(len(nums)):
            if nums[right] == 0:
                flipcount+=1
            while flipcount > k:
                if nums[left] == 0:
                    flipcount -=1
                left+=1
            count = max(count,right-left+1)
        return count
        