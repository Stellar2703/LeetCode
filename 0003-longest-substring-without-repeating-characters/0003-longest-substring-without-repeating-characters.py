from collections import Counter
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        length = 0
        sett = set ()
        left = 0
        for right in range(len(s)):
            while s[right] in sett:
                sett.remove(s[left])
                left+=1
            sett.add(s[right])
            length = max(length,len(sett))
        return length
                       

