class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;
        int curr = 0;
        for(int i=nums.length-1;i>=0;i--){
            curr = Math.max(nums[i]+prev2,prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}



// class Solution {
//     public int rob(int[] nums) {
//         int [] dp = new int[nums.length+2];
//         for(int i=nums.length-1;i>=0;i--){
//             dp[i] = Math.max(nums[i]+dp[i+2],dp[i+1]);
//         }
//         return dp[0];
//     }
// }

// class Solution {
//     public int f(int[] nums,int index,int[] dp){
//         if(index>=nums.length) return 0;
//         if(dp[index]!=-1) return dp[index];
//         int pick = nums[index] + f(nums,index+2,dp);
//         int not_pick = 0 + f(nums,index+1,dp);
//         return dp[index] = Math.max(pick,not_pick);
//     }
//     public int rob(int[] nums) {
//         int [] dp = new int[nums.length];
//         Arrays.fill(dp,-1);
//         return f(nums,0,dp);
//     }
// }


// class Solution {
//     public int f(int[] nums,int index){
//         if(index>=nums.length) return 0;
//         int pick = nums[index] + f(nums,index+2,dp);
//         int not_pick = 0 + f(nums,index+1,dp);
//         return Math.max(pick,not_pick);
//     }
//     public int rob(int[] nums) {
//         return f(nums,0,dp);
//     }
// }