class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        temp = [0] * len(boxes)
        for i in range(len(boxes)):
            if boxes[i] == "1":  # fix here
                for j in range(len(temp)):
                    temp[j] += abs(j - i)
        return temp
