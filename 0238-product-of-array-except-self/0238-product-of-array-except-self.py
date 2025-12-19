class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        suffix =1 
        prefix = 1
        ans = []
        for i in range(len(nums)):
            ans.append(suffix)
            suffix = suffix*nums[i]
        for i in range(len(nums)-1,-1,-1):
            ans[i] = ans[i]*prefix
            prefix = prefix*nums[i]
        return ans
        