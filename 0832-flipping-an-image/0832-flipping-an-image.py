class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        for i in image:
            i.reverse()
            for j in range(len(i)-1,-1,-1):
                if i[j] == 1:
                    i[j] = 0
                else:
                    i[j] = 1
        return image

        