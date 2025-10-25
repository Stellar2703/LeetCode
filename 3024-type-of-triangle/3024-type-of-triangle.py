class Solution:
    def triangleType(self, nums: List[int]) -> str:
         # Sort the sides in ascending order for easier comparison
        nums.sort()
      
        # Check triangle inequality: sum of two smaller sides must be greater than the largest side
        if nums[0] + nums[1] <= nums[2]:
            return "none"
      
        # Check if all three sides are equal (equilateral triangle)
        if nums[0] == nums[2]:
            return "equilateral"
      
        # Check if exactly two sides are equal (isosceles triangle)
        if nums[0] == nums[1] or nums[1] == nums[2]:
            return "isosceles"
      
        # If no sides are equal, it's a scalene triangle
        return "scalene"
