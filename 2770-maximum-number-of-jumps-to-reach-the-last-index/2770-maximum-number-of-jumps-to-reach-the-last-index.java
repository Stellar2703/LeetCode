class Solution {
    private int f(int index,int[] nums,int target,int[] dp){
        if(index == nums.length-1){
            return 0;
        }
        if(dp[index]!=-1) return dp[index];
        int jump = -1000;
        for(int i=index+1;i<nums.length;i++){
            int calc = nums[i]-nums[index];
            if(calc>=-target && calc<=target){
                jump = Math.max(jump,1+f(i,nums,target,dp));
            }
        }

        return dp[index]=jump;
    }
    public int maximumJumps(int[] nums, int target) {
        int[] dp =  new int[nums.length];
        Arrays.fill(dp,-1);
        int res =  f(0,nums,target,dp);

        return res<=0 ? -1 : res;
    }
}