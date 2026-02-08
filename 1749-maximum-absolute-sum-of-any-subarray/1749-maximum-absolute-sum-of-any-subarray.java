class Solution {
    public int maxAbsoluteSum(int[] nums) {
    int min_sum = nums[0] , max_sum =nums[0] ,min = nums[0] ,max = nums[0];
    for(int i = 1;i<nums.length;i++){
        min_sum = min_sum > 0 ? nums[i] : nums[i]+min_sum;
        max_sum = max_sum < 0 ? nums[i] : nums[i]+max_sum;
        max = Math.max(max,max_sum);
        min = Math.min(min,min_sum);
    }
        return Math.max(max,Math.abs(min));
    }
} 