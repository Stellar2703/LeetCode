class Solution:
    def findDuplicates(self, nums):
        # i = 0
        # while i < len(nums):
        #     correct = nums[i] - 1
        #     if nums[i] != nums[correct]:
        #         nums[i], nums[correct] = nums[correct], nums[i]
        #     else:
        #         i += 1
        # res = []
        # for i in range(len(nums)):
        #     if nums[i] != i + 1:
        #         res.append(nums[i])
        # return res
        ans = []
        for i in range(len(nums)):
            correct = abs(nums[i]) - 1
            if nums[correct] < 0:
                ans.append(correct + 1)
            else:
                nums[correct] = -nums[correct]
        return ans

