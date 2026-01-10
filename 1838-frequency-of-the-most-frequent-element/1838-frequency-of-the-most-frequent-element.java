class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long win =0;
        int l =0,ans = 0;
        for(int r =0;r<nums.length;r++){
            win+=nums[r];
            if((win+k) < ((long)nums[r]*(r-l+1)) && l<=r){
                win-=nums[l];
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}