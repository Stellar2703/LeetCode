class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        m -= 1  # Convert m to last index of actual nums1 values
        n -= 1  # Convert n to last index of nums2
        i = m + n + 1  # Final index in nums1

        while n >= 0:
            if m >= 0 and nums1[m] > nums2[n]:
                nums1[i] = nums1[m]
                m -= 1
            else:
                nums1[i] = nums2[n]
                n -= 1
            i -= 1
