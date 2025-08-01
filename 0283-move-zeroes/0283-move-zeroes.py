class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left = 0
        right = 0

        for i in range(len(nums)):
            print (nums)
            if nums[right] != 0:
                nums[right],nums[left] = nums[left],nums[right]
                left+=1
            right+=1
