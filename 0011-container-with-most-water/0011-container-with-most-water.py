class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        area = 0
        lo = 0
        hi = n-1
        while(lo<hi):
            temp = (min(height[lo],height[hi])*(hi-lo))
            area = max(temp,area)
            if(height[lo]>height[hi]):
                hi-=1
            else:
                lo+=1
        return area