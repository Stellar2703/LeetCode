class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    dp[i][j] = 1;
                }
                else{
                    int right = (i + 1 < n) ? dp[i+1][j] : 0;
                    int down  = (j + 1 < m) ? dp[i][j+1] : 0;

                    dp[i][j] = right + down;
                }
            }
        }
        return dp[0][0];
    }
}



// class Solution {
//     public int f (int i,int j ,int m,int n ,int[][]dp){
//         if(i==m-1 && j==n-1) return 1;
//         if(i==m || j==n) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
//         dp[i][j] = f(i, j + 1, m, n, dp) + f(i + 1, j, m, n, dp);
//     return dp[i][j];
//     }
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for (int i = 0; i < m; i++) {
//     for (int j = 0; j < n; j++) {
//         dp[i][j] = -1;
//     }
// }
//         return f(0, 0, m, n,dp);

//     }
// }


// class Solution {
//     public int f(int i, int j, int m, int n) {
//         if (i == m - 1 && j == n - 1) return 1;
//         if (i >= m || j >= n) return 0;

//         int right = f(i, j + 1, m, n);
//         int down  = f(i + 1, j, m, n);
//         return right + down;
//     }

//     public int uniquePaths(int m, int n) {
//         return f(0, 0, m, n);
//     }
// }
