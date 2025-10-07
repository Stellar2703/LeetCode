from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s):
            return []
        
        given = [0] * 26
        window = [0] * 26
        ans = []
        window_length = len(p)

        # Count frequency of characters in p
        for letter in p:
            given[ord(letter) - ord('a')] += 1

        # Initialize the first window
        for letter in s[:window_length]:
            window[ord(letter) - ord('a')] += 1

        # Compare first window
        if window == given:
            ans.append(0)

        # Slide the window
        for i in range(window_length, len(s)):
            window[ord(s[i]) - ord('a')] += 1                # Add new char
            window[ord(s[i - window_length]) - ord('a')] -= 1  # Remove old char
            if window == given:
                ans.append(i - window_length + 1)

        return ans
