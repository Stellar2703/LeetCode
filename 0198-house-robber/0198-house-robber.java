class Solution {
    public int f(int[]nums,int[] dp,int index){
        if(index>=nums.length)return 0;
        if(dp[index]!=-1) return dp[index];
        int pick = nums[index] + f(nums,dp,index+2);
        int not_pick =  0 + f(nums,dp,index+1);
        dp[index] = Math.max(pick,not_pick);
        return dp[index];
    }
    public int rob(int[] nums) {
        int[] dp  = new int[nums.length];
        Arrays.fill(dp,-1);
        f(nums,dp,0);
        return dp[0];
    }
}




// RECURSION

// class Solution {
//     public int f(int [] nums,int index){
//         if(index>=nums.length) return 0;
//         int pick = nums[index] + f(nums,index+2);
//         int not_pick = 0 + f(nums,index+1);
//         return Math.max(pick,not_pick);
//     }
//     public int rob(int[] nums) {
//         return f(nums,0);
//     }
// }