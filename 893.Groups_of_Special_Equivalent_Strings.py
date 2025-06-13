class Solution:
    def numSpecialEquivGroups(self, words: List[str]) -> int:
        new = set()
        for word in words:
            even = ''.join(sorted(word[::2]))
            odd =  ''.join(sorted(word[1::2]))
            combines = even + odd
            new.add(combines)
            print(even)
            print(odd)
            print(combines)
        return len(new)
        
# Breakdown:
# word[1::2] — This slices the string word starting from index 1 and taking every second character (i.e., characters at odd indices).

# sorted(...) — This returns a list of those characters, sorted in ascending order.

# ''.join(...) — This joins the sorted list of characters into a single string without any separator.