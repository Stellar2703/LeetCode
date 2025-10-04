class Solution:
    def maxArea(self, height: List[int]) -> int:
        area = 0 
        left,right=0,len(height)-1

        while left < right:

            curr_area = (right - left) * (height[left] if height[left] < height[right] else height[right]  )
            if curr_area > area:
                area = curr_area
            
            if height[left] > height[right]:
                right -= 1
            else:
                left +=1 

        return area