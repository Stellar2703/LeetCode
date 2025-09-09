class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        li = [x for x in range(int(c**0.5)+1)]
        s,e = 0,len(li)-1
        while s<=e:
            if 2*(li[s]**2) == c:
                return True
            elif 2*(li[e]**2) == c:
                return True
            elif li[s]**2 + li[e]**2 == c:
                return True
            elif li[s]**2 + li[e]**2 > c:
                e-=1
            elif li[s]**2 + li[e]**2 < c:
                s+=1
        print(li)
        return False
            