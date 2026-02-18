class Solution {
    public int f(int i, int j , int[] arr,int[][] dp){
        if(i>j) return 0;
        int maxi = Integer.MIN_VALUE;
        if(dp[i-1][j-1]!=-1) return dp[i-1][j-1];
        for(int k=i;k<=j;k++){
            int process = f(i,k-1,arr,dp) + arr[i-1]*arr[k]*arr[j+1] + f(k+1,j,arr,dp);
            maxi = Math.max(maxi,process);
        }
        return dp[i-1][j-1] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] =1;
        arr[n+1] =1;
        for(int i=1;i<=n;i++){
            arr[i] = nums[i-1];
        }
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(1,n,arr,dp);
    }
}