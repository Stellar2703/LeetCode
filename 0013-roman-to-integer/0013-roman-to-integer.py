class Solution:
    def romanToInt(self, s: str) -> int:
        num =0
        mapp = {'I': 1, 
            'V': 5, 
            'X': 10, 
            'L': 50, 
            'C': 100, 
            'D': 500, 
            'M': 1000}
        for i in range(len(s)):
            if (i<=len(s)-2 and mapp[s[i]]<mapp[s[i+1]]):
                num-=mapp[s[i]]
            else:
                num+=mapp[s[i]]
        return num
