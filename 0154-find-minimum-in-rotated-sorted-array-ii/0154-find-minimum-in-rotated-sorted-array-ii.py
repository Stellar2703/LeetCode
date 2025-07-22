class Solution:
    def findMin(self, nums: List[int]) -> int:
        start,end = 0,len(nums)-1
        while start < end:
            mid = (start+end)//2
            if nums[end] < nums[mid]:
                start = mid+1
            elif nums[end] > nums[mid]:
                end = mid
            else:
                end-=1
        return nums[start]
