class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 3:
            return 0
        
        # Only track odd numbers: index 0 = 3, index 1 = 5, etc.
        is_prime = [True] * ((n // 2))
        
        # Check odd candidates only
        for i in range(3, int(n**0.5) + 1, 2):
            if is_prime[i // 2]:
                # Start from i*i, skip evens by stepping 2*i
                is_prime[i*i // 2 :: i] = [False] * ((n - i*i - 1) // (2*i) + 1)
        
        return sum(is_prime)  # True count corresponds to odd primes + 2
