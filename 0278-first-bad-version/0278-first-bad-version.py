# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        l,r = 0,n
        first_error = -1
        while l<=r:
            m = (l+r) // 2
            if isBadVersion(m):
                first_error = m
                r= m-1
            else:
                l = m+ 1
        return first_error