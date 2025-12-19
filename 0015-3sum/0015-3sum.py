class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n=len(nums)
        ans=[]
        for i in range(len(nums)-2):
            if i>0 and (nums[i]==nums[i-1]):
                continue
            target = -nums[i]
            lo = i+1
            hi = n-1
            while (lo<hi):
                if(nums[lo] + nums[hi] == target):
                    ans.append([nums[i],nums[lo],nums[hi]])
                    lo+=1
                    hi-=1
                    while lo<hi and nums[lo] == nums[lo-1]:
                        lo+=1
                    while lo<hi and nums[hi] == nums[hi+1]:
                        hi-=1
                        
                elif(nums[lo] + nums[hi] > target ):
                    hi-=1
                else:
                    lo+=1
        return ans
            
                

        