class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        pre = ""
        for i in range(len(strs[0])):
            comp = strs[0][i]
            for s in strs:
                if i >= len(s) or s[i] != comp:
                    return pre
            pre += s[i]
        return pre
                    

