class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int l=0;
        long ans=0,sum=0;
        HashSet <Integer> mp = new HashSet<>();
        for(int r = 0;r<nums.length;r++){
            while(mp.contains(nums[r])){
                sum-=nums[l];
                mp.remove(nums[l]);
                l++;
            }
            sum+=nums[r];
            mp.add(nums[r]);
            while(r-l+1>k && l<=r){
                sum-=nums[l];
                mp.remove(nums[l]);
                l++;
            }
            if(r-l+1==k) ans = Math.max(ans,sum);
        }
    return ans;
    }
}