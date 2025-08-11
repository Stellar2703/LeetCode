class Solution:
    def lastVisitedIntegers(self, nums: List[int]) -> List[int]:
        seen = []
        ans = []
        k = 1
        for i in range(len(nums)):
            if nums[i] > 0:
                seen.append(nums[i])
                k =1
            else:
                if k > len(seen):
                    ans.append(-1)
                    k+=1
                else:
                    ans.append(seen[-k])
                    k+=1
        return ans