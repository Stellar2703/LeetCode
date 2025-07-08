class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        new = []
        left = 0
        right = len(nums)-1
        while left <= right:
            if nums[left]**2>nums[right]**2:
                new.append(nums[left]**2)
                left +=1
            else:
                new.append(nums[right]**2)   
                right -=1
        print(new)
        new.reverse()
        return new