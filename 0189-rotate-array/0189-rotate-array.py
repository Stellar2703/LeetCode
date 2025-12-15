class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        # if k > len(nums):
        #     k = k%len(nums)
        # nums[:] = nums[len(nums)-k:len(nums)]+nums[0:len(nums)-k]
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        
        if n <= 1:
            return

        k %= n
        if k == 0:
            return

        def rev(l,r):
            while l < r:
                nums[l],nums[r] = nums[r],nums[l]
                l+=1
                r-=1
        rev(0,len(nums)-1)
        rev(0,k-1)
        rev(k,len(nums)-1)








