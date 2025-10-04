class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        longest = 1
        curr = 1

        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:  # compare consecutive elements
                curr += 1
            else:
                longest = max(longest, curr)
                curr = 1  # restart count

        return max(longest, curr)
