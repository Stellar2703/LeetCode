class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # window = [0]*26
        # given = [0] *26

        # if len(s1) > len(s2):
        #     return False

        # for i in range (len(s1)):
        #     given[ord(s1[i])-ord('a')]+=1

        # for i in range (len(s1)):
        #     window[ord(s2[i])-ord('a')]+=1

        # if given == window:
        #     return True

        # for i in range(len(s1),len(s2)):
        #     window[ord(s2[i])-ord('a')]+=1
        #     window[ord(s2[i-len(s1)])-ord('a')]-=1
        #     if given == window:
        #         return True
        # return False
        giv = {}
        ans = {}
        count = 0
        for i in range(len(s1)):
            giv[s1[i]] = giv.get(s1[i], 0) + 1
        l = 0
        for r in range(len(s2)):
            ans[s2[r]] = ans.get(s2[r], 0) + 1

            if r - l + 1 > len(s1):
                ans[s2[l]] -= 1
                if ans[s2[l]] == 0:
                    del ans[s2[l]]
                l += 1
            if giv == ans:
                return True
        return False
