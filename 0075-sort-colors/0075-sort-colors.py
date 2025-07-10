class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        colors = [0,0,0]

        for i in nums:
            colors[i]+=1
        
        R,W,B = colors

        nums[:R] = [0] *R
        nums[R:R+W] = [1] * W
        nums[R+W:] = [2] * B