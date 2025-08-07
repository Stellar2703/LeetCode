from collections import Counter
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        coun = Counter(nums)
        for i in coun:
            if coun[i] > (len(nums)/2):
                return i