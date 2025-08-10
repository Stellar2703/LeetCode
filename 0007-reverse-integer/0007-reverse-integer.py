class Solution:
    def reverse(self, x: int) -> int:
        def reverse_num(x):
            num = 0
            while x > 0 :
                num = (num*10) + (x % 10)
                x = x // 10
            return num
        rev_num = reverse_num(x) if x > 0 else reverse_num(-x)
        if rev_num >= 2**31 or rev_num <= -2**31:
            return 0
        return rev_num if x>0 else -rev_num