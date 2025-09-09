class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        s,e = 0,int(c**0.5)+1
        while s <= e:
            curr = s*s + e*e
            if curr == c:
                return True
            elif curr > c:
                e -= 1
            else:
                s += 1
        return False