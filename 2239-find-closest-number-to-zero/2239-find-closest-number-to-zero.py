class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        num = float('inf')
        for i in nums:
            if abs(i) < abs(num) or (abs(i) == abs(num) and i > num):
                num = i
        return num