from collections import Counter
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        b = Counter(nums)
        # print(b)
        for i in b:
            if b[i] == 1:
                return i
        