class Solution:
    def maxProduct(self, words: List[str]) -> int:
        prod = 0
        for i in range(len(words)):
            for j in range(i+1, len(words)):
                # Check if they share no common letters
                if not (set(words[i]) & set(words[j])):
                    prod = max(prod, len(words[i]) * len(words[j]))
        return prod