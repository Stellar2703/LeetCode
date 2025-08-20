class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        i = 0
        lo = prices[0]
        hi = prices[0]
        profit = 0
        while i < len(prices)-1:
            while i < len(prices)-1 and prices[i]>=prices[i+1]:
                i+=1
            lo = prices[i]
            # where to buy so highest point
            while i < len(prices)-1 and prices[i]<=prices[i+1]:
                i+=1
            hi = prices[i]
            profit += (hi-lo)
        return profit