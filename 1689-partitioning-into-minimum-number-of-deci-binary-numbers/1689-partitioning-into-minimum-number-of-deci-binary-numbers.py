class Solution:
    def minPartitions(self, n: str) -> int:
        a = [int(x) for x in n]
        return max(a)        

