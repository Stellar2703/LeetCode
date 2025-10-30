class Solution:

    def containsNearbyDuplicate(self, nums, k):
        index_map = {}  # number -> last index

        for i, num in enumerate(nums):
            if num in index_map and i - index_map[num] <= k:
                return True
            index_map[num] = i  # update last index of num

        return False
