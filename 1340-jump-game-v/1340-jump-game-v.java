class Solution {
    private int f(int[] nums,int index,int d,int[] dp){
        int res = 1;
        if(dp[index]!=-1) return dp[index];
        for(int i=index-1;i>=Math.max(0,index-d) &&nums[index]>nums[i];i--){
            res = Math.max(res,1+f(nums,i,d,dp));
        }
        for(int i=index+1;i<=Math.min(nums.length-1,index+d) && nums[index]>nums[i];i++){
            res = Math.max(res,1+f(nums,i,d,dp));
        }
        return dp[index]=res;
    }
    public int maxJumps(int[] arr, int d) {
        int max = 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        for(int i =0;i<arr.length;i++){
            max= Math.max(max,f(arr,i,d,dp));
        }
        return max;
    }
}