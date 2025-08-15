class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        l = [0] * len(nums)
        r = [0] * len(nums)
        l_num,r_num = 1,1
        for i in range(len(nums)):
            j = -i -1
            l[i] = l_num
            r[j] = r_num
            l_num*=nums[i]
            r_num*=nums[j]
        return [x*y for x,y in zip(l,r)]
