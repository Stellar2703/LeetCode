class Solution:
    def reverseWords(self, s: str) -> str:
        li = []
        if s[0].isalnum():
                li.append(0)
        for i in range(1,len(s)):
            if s[i-1]==' ' and s[i].isalnum():
                li.append(i)
            if s[i-1].isalnum() and s[i] == ' ':
                li.append(i-1)
        if s[len(s)-1].isalnum():
            li.append(len(s)-1)
        newli = []
        for i in range(len(li)-1,0,-2):
            start = li[i-1]
            end = li[i]
            word = s[start:end+1]
            newli.append(word)  # reverse each word
        return " ".join(newli)


