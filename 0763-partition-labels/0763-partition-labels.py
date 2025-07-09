class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        lastindex = {}
        for  index,char in enumerate(s):
            lastindex[char] = index
        output = []
        size,end = 0,0
        for  index,char in enumerate(s):
            size += 1
            if lastindex[char] > end:
                end = lastindex[char]
            if index == end:
                output.append(size)
                size =0
        return output
