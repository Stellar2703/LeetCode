class Solution {
    public int uniquePaths(int m, int n) {
        int [] next = new int[n];
        int [] curr = new int[n];

        for(int i=m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(i==m-1 && j==n-1) {
                    curr[j] =1;
                    continue;
                }
                int right = j+1<n ? curr[j+1]  : 0;
                int down = i+1<m ? next[j]  : 0;
                
                curr[j] = right + down;
            }
            next = curr.clone();
        }
        return next[0];
    }
}




// class Solution {
//     public int uniquePaths(int m, int n) {
//         int [][] dp = new int[m][n];
//         dp[m-1][n-1]  = 1;
//         for(int i = m-1;i>=0;i--){
//             for(int j=n-1;j>=0;j--){
//                 if(j==n-1 && i == m-1) continue;
//                 int down = (i+1<=m-1) ? dp[i+1][j] : 0 ;
//                 int right = (j+1<=n-1) ? dp[i][j+1] : 0 ;

//                 dp[i][j] = right+down;
//             }
//         }
//         return dp[0][0];
//     }
// }













// class Solution {
//     public int f(int i , int j,int m,int n,int[][] dp){
//         if(i==m-1 && j==n-1) return 1;
//         if(i>=m || j>=n) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];

//         int down = f(i+1,j,m,n,dp);
//         int right = f(i,j+1,m,n,dp);

//         return dp[i][j] = right+down;
//     }
//     public int uniquePaths(int m, int n) {
//         int [][] dp = new int[m][n];
//         for(int i =0;i<m;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return f(0,0,m,n,dp);
//     }
// }