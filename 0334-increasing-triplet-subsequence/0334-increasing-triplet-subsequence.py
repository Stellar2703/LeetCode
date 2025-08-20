class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        first,second=float('inf'),float('inf')

        for n in nums:
            if n <= first:
                first = n   # new smallest
            elif n <= second:
                second = n  # new second smallest
            else:
                return True  # found n > second > first
        return False