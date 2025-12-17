class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ans= []
        hashmap = {}
        for i in range(len(nums)):
            required =target - nums[i]
            if required in hashmap:
                return [i,hashmap[required]]
            hashmap[nums[i]] = i
        