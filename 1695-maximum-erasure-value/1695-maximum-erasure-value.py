class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        dic = {}
        l = 0
        summ = 0
        max_sum = 0
        for r in range(len(nums)):
            summ+=nums[r]
            dic[nums[r]] = dic.get(nums[r],0)+1            
            while dic[nums[r]]>1:
                dic[nums[l]] = dic.get(nums[l],0)-1
                summ-=nums[l]
                l+=1
            max_sum = max(summ,max_sum)
        return max_sum
