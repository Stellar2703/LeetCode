class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        count = 0
        summ= 0
        for right in range(len(nums)):
            if nums[right]==1:
                count+=1
            else:
                count = 0
            summ = max(summ,count)
        return summ