class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        closest = float(inf)
        nums.sort()
        for i in range(len(nums)):
            low,high = i+1,len(nums)-1

            while low < high:
                
                summ = nums[i] +nums[low] + nums [high]
                if summ == target:
                    return target

                if abs(target - summ) < abs(target-closest):
                    closest = summ

                if summ < target:
                    low+=1
                else:
                    high -=1
        return closest
                