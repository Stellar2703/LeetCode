class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        chk = [0] * 26
        for i in s:
            chk [ord(i)-ord('a')] += 1
        for i in t:
            chk [ord(i)-ord('a')] -= 1
        for i in chk:
            if i != 0:
                return False
        return True
        