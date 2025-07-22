class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums[0] <= nums[-1]:
            return nums[0]
        start,end=0,len(nums)-1
        while start < end:
            mid = (start+end)//2
            if nums[end] <= nums[mid]:
                start = mid+1
            else:
                end = mid
        return nums[start]
        
    
        