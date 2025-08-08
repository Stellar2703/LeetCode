class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        num = 0
        for i in range(len(nums)):
            num+= nums[i]

        return num % k
        