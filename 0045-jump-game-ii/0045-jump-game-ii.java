class Solution {
    public int f(int[] nums,int index,int[]dp){
        if(index==nums.length-1) return 0;
        if(index>=nums.length) return 1000000;
        if(dp[index]!=-1) return dp[index];
        int min=1000000;
        for(int i=1;i<=nums[index];i++){
            if(index+i<nums.length){
                min = Math.min(1 + f(nums,index+i,dp),min);
                dp[index] = min;
            }
        }
        return min;
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return f(nums,0,dp);
    }
}