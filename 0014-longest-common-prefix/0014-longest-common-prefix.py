class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        # pre = ""
        # for i in range(len(strs[0])):
        #     comp = strs[0][i]
        #     for s in strs:
        #         if i >= len(s) or s[i] != comp:
        #             return pre
        #     pre += s[i]
        # return pre
        strs.sort()
        first = strs[0]
        last = strs[-1]
        ans = ""
        for i in range(min(len(first),len(last))):
            if(first[i]!=last[i]):
                return ans
            ans+=first[i]
        return ans

                    

