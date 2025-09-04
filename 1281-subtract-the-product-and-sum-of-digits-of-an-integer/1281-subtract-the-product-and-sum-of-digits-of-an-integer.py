class Solution:
    def subtractProductAndSum(self, n: int) -> int:

        a = [int(x) for x in str(n)]

        digit_sum = sum(a)

        product = 1
        for x in a:
            product *= x
        return product -digit_sum
        