from collections import Counter
class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        counter = Counter(nums)
        return [numbers for numbers in counter if counter[numbers] ==2]
