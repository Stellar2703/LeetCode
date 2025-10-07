class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        window = [0]*26
        given = [0] *26

        if len(s1) > len(s2):
            return False

        for i in range (len(s1)):
            given[ord(s1[i])-ord('a')]+=1
        
        for i in range (len(s1)):
            window[ord(s2[i])-ord('a')]+=1

        if given == window:
            return True

        for i in range(len(s1),len(s2)):
            window[ord(s2[i])-ord('a')]+=1
            window[ord(s2[i-len(s1)])-ord('a')]-=1
            if given == window:
                return True
        return False

