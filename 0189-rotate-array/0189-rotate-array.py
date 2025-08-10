class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if k > len(nums):
            k = k%len(nums)
        nums[:] = nums[len(nums)-k:len(nums)]+nums[0:len(nums)-k]
        """
        Do not return anything, modify nums in-place instead.
        """
        