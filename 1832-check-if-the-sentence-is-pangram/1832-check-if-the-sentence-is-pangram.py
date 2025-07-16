class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        lis = [0]*26
        for i in sentence:
            lis[ord(i)-ord('a')] +=1
        for i in range(26):
            if lis[i] == 0:
                return False
        return True