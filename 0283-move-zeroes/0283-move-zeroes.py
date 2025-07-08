class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left = 0
        right = 0

        while left < len(nums):
            if nums[left] != 0:
                nums[left],nums[right] = nums[right],nums[left]
                right = right + 1
            left = left + 1