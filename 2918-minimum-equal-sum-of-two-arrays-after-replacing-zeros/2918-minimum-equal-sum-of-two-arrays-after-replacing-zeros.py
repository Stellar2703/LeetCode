class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        z1 = nums1.count(0)
        z2 = nums2.count(0)
        s1 = sum(nums1)
        s2 = sum(nums2)

        if z1 == 0 and z2 == 0:
            if s1 == s2:
                return s1
            return -1
        elif z2 == 0 :
            if s2 >= s1 + z1:
                return s2
            return -1
        elif z1 == 0:
            if s1 >= s2 + z2:
                return s1
            return -1
        else:
            return max(s1+z1,s2+z2)


        