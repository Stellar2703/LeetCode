from collections import Counter
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # coun = Counter(nums)
        # for i in coun:
        #     if coun[i] > (len(nums)/2):
        #         return i
        num = nums[0]
        count = 0
        for i in nums:
            if count == 0:
                num = i
            if i == num:
                count +=1
            else:
                count-=1
        return num
