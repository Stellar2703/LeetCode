class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        count = 0
        start = False
        for i in range(len(s)):
            if s[i] != " " :
                if start:
                    count = 1
                    start = False
                else:
                    count =count+1
            else:
                start = True
        return count