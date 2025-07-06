class Solution:
    def longestPalindrome(self, s: str) -> int:
        res_lower = [0] * 26
        res_upper = [0] * 26

        for ch in s:
            if ch.islower():
                res_lower[ord(ch) - ord('a')] += 1
            elif ch.isupper():
                res_upper[ord(ch) - ord('A')] += 1

        length = 0
        odd_found = False

        for freq in res_lower + res_upper:
            length += (freq // 2) * 2
            if freq % 2 == 1:
                odd_found = True

        if odd_found:
            length += 1

        return length
