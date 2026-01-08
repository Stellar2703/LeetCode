class Solution {
    public int longestSubarray(int[] nums) {
        int count =0,l=0,ans=0;
        for(int r =0;r<nums.length;r++){
            if(nums[r]==0) count++;
            while(count>1){
                if(nums[l]==0) count--;
                l++;
            }
            ans = Math.max(ans,r-l);
        }
        return ans;
    }
}