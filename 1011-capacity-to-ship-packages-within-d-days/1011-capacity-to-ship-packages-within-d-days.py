class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l = max(weights)
        r = sum(weights)
        res = float('inf')
        while l <= r:
            ships = 1
            summ = 0
            mid = (l+r)//2
            for i in range(len(weights)):
                if summ + weights[i] > mid:
                    summ = 0 
                    ships+=1
                summ += weights[i]
            if ships <= days:
                res = min(res,mid)
                r = mid -1
            else:
                l = mid + 1
        return res
                
                
                

        