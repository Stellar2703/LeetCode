class Solution:
    def targetIndices(self, nums: List[int], target: int) -> List[int]:
        nums.sort()
        def first_num():
            l,r=0,len(nums) -1
            first = -1
            while l<=r:
                m = (l + r) // 2
                if nums[m] == target:
                    first = m
                    r = m-1
                elif nums[m] < target:
                    l = m +1
                else:
                    r = m-1
            return first
        def last_num():
            last = -1
            l,r=0,len(nums) -1
            while l<=r:
                m = (l + r) // 2
                if nums[m] == target:
                    last = m
                    l = m+1
                elif nums[m] < target:
                    l = m +1
                else:
                    r = m-1
            return last
        first = first_num()
        last = last_num()

        if first == -1:
            return []

        return list(range(first, last + 1))