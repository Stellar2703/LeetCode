class Solution {
    public int f(int[][] matrix, int i,int j,Integer[][]dp){
        int n = matrix.length;
        if(i==n-1) return matrix[i][j];
        if(dp[i][j]!= null) return dp[i][j];
        int left = Integer.MAX_VALUE, middle = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(j>0 && j<n) left = matrix[i][j] + f(matrix,i+1,j-1,dp);
        if(j>=0 && j<n) middle = matrix[i][j] + f(matrix,i+1,j,dp);
        if(j>=0 && j<n-1) right = matrix[i][j] + f(matrix,i+1,j+1,dp);
        return dp[i][j] = Math.min(left,Math.min(right,middle));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int path = Integer.MAX_VALUE;
        Integer[][] dp = new Integer [n][n];
        for(int i = 0;i<n;i++){
            path = Math.min(path,f(matrix,0,i,dp));
        }
        return path;
    }
}













// class Solution {
//     public int f(int[][] matrix, int i,int j){
//         int n = matrix.length;
//         if(i==n-1) return matrix[i][j];
//         int left = Integer.MAX_VALUE, middle = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
//         if(j>0 && j<n) left = matrix[i][j] + f(matrix,i+1,j-1);
//         if(j>=0 && j<n) middle = matrix[i][j] + f(matrix,i+1,j);
//         if(j>0 && j<n-1) right = matrix[i][j] + f(matrix,i+1,j+1);
//         return Math.min(left,Math.min(right,middle));
//     }
//     public int minFallingPathSum(int[][] matrix) {
//         int path = Integer.MAX_VALUE;
//         for(int i = 0;i<matrix.length;i++){
//             path = Math.min(path,f(matrix,0,i));
//         }
//         return path;
//     }
// }