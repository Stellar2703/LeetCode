class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0:
            return [[]]
        first_char = nums[0]
        small_permute = self.permuteUnique(nums[1:])
        all_permute = []
        seen = set()
        for each_permute in small_permute:

            for position in range(0,len(each_permute)+1):
                temp = each_permute[:position] + [first_char] + each_permute[position:]
                sett = tuple(temp)
                if sett not in seen:
                    seen.add(sett)
                    all_permute.append(temp)
        return all_permute
