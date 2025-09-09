class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        s,e = 0,int(c**0.5)+1
        while s <= e:
            curr = s*s + e*e
            if 2*(s*s) == c:
                return True
            if 2*(e*e) == c:
                return True
            if curr == c:
                return True
            elif curr > c:
                e -= 1
            else:
                s += 1
        return False