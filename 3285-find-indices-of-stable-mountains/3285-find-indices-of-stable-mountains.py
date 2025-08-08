class Solution:
    def stableMountains(self, height: List[int], threshold: int) -> List[int]:
        arr = []
        for i in range(1,len(height)):
            if height[i-1] > threshold:
                arr.append(i)
        return arr
        