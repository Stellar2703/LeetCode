class Solution {

    private int f(int left, int right, int[] nums,int[][] dp) {
        if (left == right) {
            return nums[left];
        }
        if(dp[left][right]!=-1) return dp[left][right];
        int takeLeft = nums[left] - f(left + 1, right, nums,dp);
        int takeRight = nums[right] - f(left, right - 1, nums,dp);

        return dp[left][right]=Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {
        int[][] dp =  new int[nums.length][nums.length];
        for(int i =0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0, nums.length - 1, nums,dp) >= 0;
    }
}