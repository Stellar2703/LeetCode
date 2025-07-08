class Solution:
    def longestPalindrome(self, s: str) -> str:
        left = 0
        right = 0
        max_len = 0
        def isPalindrome(s):
            return s == s[::-1]
        for i in range(len(s)):
            for j in range(i,len(s)):
                if isPalindrome(s[i:j+1]):
                    if max_len < j-i+1:
                        left = i
                        right = j
                        max_len = j-i+1
        return s[left:right+1]