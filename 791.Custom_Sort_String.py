from collections import Counter
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        coun = Counter(s)
        new_list=[]
        for i in order:
            new_list.append(i*coun[i])
        
        for i in s:
            if i not in order:
                new_list.append(i)

        a="".join(new_list)
        return a