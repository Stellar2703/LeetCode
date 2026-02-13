class Solution {
    public int f(int [][] grid , int i,int j,int[][] dp){
        if(i==grid.length-1 && j== grid[0].length-1) return grid[i][j] ;
        if(i>=grid.length || j>= grid[0].length) return 1000000;
        if(dp[i][j]!=-1) return dp[i][j];
        int right = grid[i][j] + f(grid,i,j+1,dp);
        int down = grid[i][j] + f(grid,i+1,j,dp);

        return dp[i][j]= Math.min(right,down);

    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int [n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(grid,0,0,dp);
    }
}