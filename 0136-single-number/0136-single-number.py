from collections import Counter
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # b = Counter(nums)
        # # print(b)
        # for i in b:
        #     if b[i] == 1:
        #         return i
        

        xor = nums[0]
        for i in range(1,len(nums)):
            xor = xor^nums[i]
        return xor