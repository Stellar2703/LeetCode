class Solution:
    def twoOutOfThree(self, nums1: List[int], nums2: List[int], nums3: List[int]) -> List[int]:
        case1 =set(nums1)& set(nums2)
        case2 =set(nums1)& set(nums3)
        case3 =set(nums3)& set(nums2)
        return list(set(list(case1)+list(case2)+list(case3)))