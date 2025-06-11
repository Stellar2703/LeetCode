from collections import Counter
class Solution:
    def firstUniqChar(self, s: str) -> int:
        cou = Counter(s)
        print(cou)
        for i in cou:
            if cou[i] == 1:
                return s.index(i)
        return -1