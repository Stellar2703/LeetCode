from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if digits == '':
            return []
        
        num = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"
        }
        if len(digits) == 1:
            return list(num[digits[0]])

        ans = []

        small_ans = self.letterCombinations(digits[1:])

        for keypad_words in num[digits[0]]:
            for my_perm_ans in small_ans:
                ans.append(keypad_words+my_perm_ans)
        return ans