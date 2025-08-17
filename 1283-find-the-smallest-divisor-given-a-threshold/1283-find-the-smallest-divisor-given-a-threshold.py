class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        l , r =1,max(nums)
        
        while l <= r:
            mid = (l+r) // 2

            divisor_sum  = sum ((n + mid - 1)// mid for n in nums)

            if divisor_sum <= threshold:
                r = mid - 1
            else:
                l = mid + 1
            
        return l
