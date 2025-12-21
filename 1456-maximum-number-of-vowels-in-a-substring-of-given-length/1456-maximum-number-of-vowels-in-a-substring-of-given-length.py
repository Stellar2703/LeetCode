class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vow = {'a', 'e', 'i', 'o', 'u'}
        count = 0
        l=0
        max_count=0
        for i in range(k):
            if(s[i] in vow):
                count+=1
        max_count=count
        for r in range(k,len(s)):
            if s[r] in vow:
                count+=1
            if s[l] in vow:
                count-=1
            l+=1
            max_count=max(max_count,count)
        return max_count