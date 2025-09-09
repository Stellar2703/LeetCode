class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        maxx = 0
        s,e = 0,len(nums)-1
        while s<e:
            maxx = max(maxx,(nums[s]+nums[e]))
            s+=1
            e-=1
        return maxx
        