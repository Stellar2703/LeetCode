class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        l = 0
        cost = 0
        ans = 0
        for r in range(len(s)):
            if s[r] != t[r]:
                cost+= abs(ord(s[r])-ord(t[r]))
            if cost>maxCost:
                if s[l] !=t[l]:
                    cost-= abs(ord(s[r])-ord(t[r]))
                l+=1
            ans = max(r-l+1,ans)
        return ans
            
