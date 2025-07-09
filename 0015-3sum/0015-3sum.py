class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        answer = []
        for i in range(len(nums)):
            if nums[i]>0:
                break
            elif i > 0 and nums[i] == nums[i-1]:
                continue
            low = i+1
            high = len(nums)-1
            while low < high:
                if nums[i] + nums[low] + nums[high] == 0:
                    answer.append([nums[i],nums[low],nums[high]])
                    low +=1
                    high -=1
                    while low < high and nums[low] == nums[low-1]:
                        low +=1
                    while low < high and nums[high] == nums[high+1]:
                        high -=1  
                elif nums[i] + nums[low] + nums[high] < 0:
                    low +=1
                elif nums[i] + nums[low] + nums[high] > 0:
                    high -=1
        return answer

