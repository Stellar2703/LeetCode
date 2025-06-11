class Solution(object):
    def optimalDivision(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        if len(nums) == 1:
            return str(nums[0])
        if len(nums) == 2:
            return f'{nums[0]}/{nums[1]}'
        # For 3 or more numbers, wrap the rest in parentheses to maximize the result
        return f'{nums[0]}/({"/".join(map(str, nums[1:]))})'