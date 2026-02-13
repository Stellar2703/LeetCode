class Solution {
    public int f(int[][] grid,int i ,int j,int[][] dp){
        if(i==grid.length-1 && j==grid[0].length-1) {
            if(grid[i][j]==0)
            return 1;
            else return 0;
        }
        if(i>grid.length-1 || j>grid[0].length-1) return 0;
        if(grid[i][j]==1)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int right = f(grid,i+1,j,dp);
        int down = f(grid,i,j+1,dp);

        return dp[i][j]=right+down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][]dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(obstacleGrid,0,0,dp);
    }
}