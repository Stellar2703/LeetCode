class Solution {

    private int f(int index, int row, int[] obstacles,int[][] dp){

        if(index == obstacles.length - 1){
            return 0;
        }
        if(dp[index][row]!= -1) return dp[index][row];

        // move forward
        if(obstacles[index + 1] != row){
            return dp[index][row] = f(index + 1, row, obstacles,dp);
        }

        int ans = 10000000;

        // side jump
        for(int i = 1; i <= 3; i++){

            if(i != row && obstacles[index] != i){

                ans = Math.min(ans,
                        1 + f(index, i, obstacles,dp));
            }
        }

        return dp[index][row] =ans;
    }

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n+1][4];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0, 2, obstacles,dp);
    }
}