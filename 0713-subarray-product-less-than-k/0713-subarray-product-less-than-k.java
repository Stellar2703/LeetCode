class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=1) return 0;
        int count =0,prod = 1,l=0;
        for(int r = 0;r<nums.length;r++){
            prod*=nums[r];
            while(prod>=k && l<=r){
                prod/=nums[l];
                l++;
            }
            if(prod<k){
                count+=(r-l+1);
            }
        }
        return count;
    }
}