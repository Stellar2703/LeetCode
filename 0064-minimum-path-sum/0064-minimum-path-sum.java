class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1)dp[i][j] = grid[i][j];
                else{
                    int right = j+1<m ? dp[i][j+1] : 1000000;
                    int down = i+1<n ? dp[i+1][j] : 1000000;
                    dp[i][j] = grid[i][j] + Math.min(right,down);
                }
            }
        }
            return dp[0][0];
    }
}


// // class Solution {
//     public int f(int [][] grid , int i,int j,int[][] dp){
//         if(i==grid.length-1 && j== grid[0].length-1) return grid[i][j] ;
//         if(i>=grid.length || j>= grid[0].length) return 1000000;
//         if(dp[i][j]!=-1) return dp[i][j];
//         int right = grid[i][j] + f(grid,i,j+1,dp);
//         int down = grid[i][j] + f(grid,i+1,j,dp);

//         return dp[i][j]= Math.min(right,down);   

//     }
//     public int minPathSum(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int [][] dp = new int [n+1][m+1];
//         for(int i=0;i<=n;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return f(grid,0,0,dp);
//     }
// }