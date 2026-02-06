class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        if (n == 1)
            return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[1], nums[0]);
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for (int i = 2; i <= n - 2; i++) {
            dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
        }

        for (int i = 3; i <= n - 1; i++) {
            dp2[i] = Math.max(dp2[i - 1], nums[i] + dp2[i - 2]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);

    }
}

// Memoization

// class Solution {
//     public int f(int index,int end, int[] nums, int[] dp){
//         if(index>end) return 0;
//         if(dp[index]!=-1) return dp[index];
//         int pick = nums[index] + f(index+2,end,nums,dp);
//         int not_pick = 0 + f(index+1,end,nums,dp);
//         dp[index] = Math.max(pick,not_pick);
//         return dp[index];
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 1) return nums[0];
//         int dp1[] = new int[n];
//         int dp2[] = new int[n];
//         Arrays.fill(dp1,-1);
//         Arrays.fill(dp2,-1);
//         f(0,n-2,nums,dp1);
//         f(1,n-1,nums,dp2);
//         return Math.max(dp1[0],dp2[1]);
//     }
// }

// RECURSION

// class Solution {
//     public int f(int index,int end,int[] nums){
//         if(index>end){
//             return 0;
//         }
//         int pick = nums[index]+f(index+2,end,nums);
//         int not_pick = 0+f(index+1,end,nums);
//         return Math.max(pick,not_pick);
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;
//         return Math.max(f(0,n-2,nums),f(1,n-1,nums));
//     }
// }