class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        res = [0] * 26
        for i in s:
            res[ord(i)-ord('a')] +=1
        for i in t:
            res[ord(i)-ord('a')] -=1
        for i in range(26):
            if res[i] != 0:
                return chr(i + ord('a'))
                
