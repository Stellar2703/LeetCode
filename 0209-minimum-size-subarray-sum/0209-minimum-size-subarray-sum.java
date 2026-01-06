class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l= 0,r=0,curr_sum=0,max_sum=Integer.MAX_VALUE;
        while(r<nums.length){
            curr_sum+=nums[r];
            while(curr_sum>=target ){
                max_sum = Math.min(max_sum,r-l+1);
                curr_sum-=nums[l];
                l++;
            }
            r++;
        }
        return max_sum== Integer.MAX_VALUE ? 0 : max_sum;
    }
}