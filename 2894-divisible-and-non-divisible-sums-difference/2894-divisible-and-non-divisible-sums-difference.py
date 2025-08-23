class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        total_sum = n * (n + 1) // 2
        
        # number of multiples of m up to n
        k = n // m
        
        # sum of multiples of m
        sum_multiples = m * k * (k + 1) // 2
        
        # difference
        return total_sum - 2 * sum_multiples
