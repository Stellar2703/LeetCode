from typing import List

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum = nums[0]         # Initialize with first element
        curr_sum = nums[0]

        for i in nums[1:]:
            curr_sum = max(i, curr_sum + i)  # continue or start fresh
            max_sum = max(max_sum, curr_sum) # update max

        return max_sum
