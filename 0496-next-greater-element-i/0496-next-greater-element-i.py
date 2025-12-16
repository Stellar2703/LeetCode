class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans=[]
        for i in range(len(nums1)):
            nge = False
            for j in range(len(nums2)):
                if nums1[i] == nums2[j]:
                    for k in range(j+1,len(nums2)):
                        if nums2[k] > nums2[j]:
                            # ans.append(nums2[k])
                            nums1[i] = nums2[k]
                            nge = True
                            break
                    break
            if not nge:
                nums1[i] = -1
        return nums1