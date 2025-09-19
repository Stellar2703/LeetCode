from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        
        num = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"
        }
        
        # base case: only one digit left
        if len(digits) == 1:
            return list(num[digits[0]])
        
        # recursive step
        smaller_combinations = self.letterCombinations(digits[1:])
        first_digit_letters = num[digits[0]]
        
        ans = []
        for letter in first_digit_letters:           # pick a letter for first digit
            for combo in smaller_combinations:       # extend with all smaller combos
                ans.append(letter + combo)
        
        return ans
