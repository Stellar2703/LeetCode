class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans=[-1]*len(nums1)
        for i in range(len(nums1)):
            # nge = False
            for j in range(len(nums2)):
                if nums1[i] == nums2[j]:
                    for k in range(j+1,len(nums2)):
                        if nums2[k] > nums2[j]:
                            # ans.append(nums2[k])
                            # nge = True
                            ans[i] = nums2[k]
                            break
                    break
            # if not nge:
            #     ans.append(-1)
        return ans