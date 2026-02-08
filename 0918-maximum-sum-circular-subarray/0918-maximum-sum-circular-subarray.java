class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0];
        int min =nums[0],max=nums[0],min_sum = nums[0],max_sum=nums[0];
        for(int i=1;i<nums.length;i++){
            max = max < 0 ? nums[i] : nums[i]+max;
            min = min > 0 ? nums[i] : nums[i]+min;
            min_sum = Math.min(min,min_sum);
            max_sum = Math.max(max,max_sum);
            total+=nums[i];
        }

        if (max_sum < 0) return max_sum;

        return Math.max(max_sum,total-min_sum);

    }
}