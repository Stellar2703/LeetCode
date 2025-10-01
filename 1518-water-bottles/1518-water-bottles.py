class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        ans = numBottles
        empty = numBottles

        while empty >= numExchange:   
            temp = empty // numExchange 
            ans += temp
            empty = (empty % numExchange) + temp

        return ans
