class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        l1, l2 = 0, 0
        ans = []

        while l1 < len(firstList) and l2 < len(secondList):
            start = max(firstList[l1][0], secondList[l2][0])
            end = min(firstList[l1][1], secondList[l2][1])
            
            if start <= end:
                ans.append([start, end])
            # # first inside second
            # if firstList[l1][0] >= secondList[l2][0] and firstList[l1][1] <= secondList[l2][1]:
            #     ans.append([firstList[l1][0], firstList[l1][1]])

            # # partial overlap: first starts before second and ends inside second
            # elif firstList[l1][0] <= secondList[l2][0] and firstList[l1][1] <= secondList[l2][1]:
            #     ans.append([secondList[l2][0], firstList[l1][1]])

            # # partial overlap: first starts inside second and ends after second
            # elif firstList[l1][0] >= secondList[l2][0] and firstList[l1][1] >= secondList[l2][1]:
            #     ans.append([firstList[l1][0], secondList[l2][1]])

            # # second inside first / partial overlap: second starts before first and ends inside first
            # elif secondList[l2][0] <= firstList[l1][0] <= secondList[l2][1] <= firstList[l1][1]:
            #     ans.append([firstList[l1][0], secondList[l2][1]])

            # move the interval that ends first
            if firstList[l1][1] < secondList[l2][1]:
                l1 += 1
            else:
                l2 += 1

        return ans
