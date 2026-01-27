class Solution {
    public int f(int[] nums, int goal){
        int sum = 0,l=0,count=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
                count+=(r-l+1);
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
    if(goal==0) return f(nums,goal);
    return f(nums,goal) - f(nums,goal-1);
}
}