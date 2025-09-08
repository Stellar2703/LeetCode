class Solution:
    def missingNumber(self, nums: List[int]) -> int:

        return reduce(xor, (index ^ value for index, value in enumerate(nums, 1)))