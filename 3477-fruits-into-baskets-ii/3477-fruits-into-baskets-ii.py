class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        unmatched = 0
        for i in range(len(fruits)):
            placed = False
            for j in range(len(baskets)):
                if baskets[j] >= fruits[i]:
                    placed = True
                    baskets[j] = 0
                    break
            if placed == False:
                unmatched +=1

        return unmatched

        