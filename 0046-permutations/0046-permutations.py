class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        if len(nums)==0:
            return [[]]

        first_char=nums[0]
        small_permutation = self.permute(nums[1:])
        all_permutations = []
        for eachpermuation in small_permutation:
            for position in range(0,len(eachpermuation)+1):
                temp = eachpermuation[:position]+[first_char]+eachpermuation[position:]
                all_permutations.append(temp)
        return all_permutations