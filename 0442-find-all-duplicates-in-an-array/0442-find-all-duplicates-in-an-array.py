# class Solution(object):
#     def findDuplicates(self, nums):
        # """
        # :type nums: List[int]
        # :rtype: List[int]
        # """
        # l = 0
        # while (l<len(nums)):
        #     if(nums[l]!= nums[nums[l]-1]):
        #         nums[l],nums[nums[l]-1] = nums[nums[l]-1], nums[l]
        #     else:
        #         l+=1
        # return nums
class Solution:
    def findDuplicates(self, nums):
        i = 0
        while i < len(nums):
            correct = nums[i] - 1
            if nums[i] != nums[correct]:
                nums[i], nums[correct] = nums[correct], nums[i]
            else:
                i += 1

        res = []
        for i in range(len(nums)):
            if nums[i] != i + 1:
                res.append(nums[i])

        return res
