class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0,max = 0;
        for(int r = 0;r<k;r++) sum+=nums[r];
        max = sum/k;
        for(int r=k;r<nums.length;r++){
            sum+=nums[r];
            sum-=nums[r-k];
            max = Math.max(max,sum/k);
        }
        return max;
    }
}