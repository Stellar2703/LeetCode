class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [] dp = new int[triangle.get(n-1).size()];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j <=triangle.get(i).size()-1;j++){
                if(i==n-1){
                    dp[j] = triangle.get(i).get(j);
                    continue;
                }
                int down  = triangle.get(i).get(j) + dp[j];
                int right = triangle.get(i).get(j) + dp[j+1];
                dp[j] = Math.min(down,right);
            }
        }
        return dp[0];
    }
}


// class Solution {
//     public int f(int i,int j,List<List<Integer>> tri,int[][] dp){
//         if(i == tri.size()) return 0;
//         if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        
//         int down = tri.get(i).get(j) + f(i+1,j,tri,dp);
//         int right = tri.get(i).get(j) + f(i+1,j+1,tri,dp);

//         return dp[i][j] = Math.min(down,right);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int m = triangle.get(n-1).size();
//         int [][] dp = new int [n][m];
//         for(int i =n-1;i>=0;i--){
//             for(int j=triangle.get(i).size()-1;j>=0;j--){
//                 if(i==n-1){
//                     dp[i][j] = triangle.get(i).get(j);
//                     continue;
//                 }
//                 int right = triangle.get(i).get(j) + dp[i+1][j+1];
//                 int down  = triangle.get(i).get(j) + dp[i+1][j];
//                 dp[i][j] = Math.min(right,down);
//             }
//         }
//         return dp[0][0];
//     }
// }





// class Solution {
//     public int f(int i,int j,List<List<Integer>> tri,int[][] dp){
//         if(i == tri.size()) return 0;
//         if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        
//         int down = tri.get(i).get(j) + f(i+1,j,tri,dp);
//         int right = tri.get(i).get(j) + f(i+1,j+1,tri,dp);

//         return dp[i][j] = Math.min(down,right);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int m = triangle.get(n-1).size();
//         int [][] dp = new int [n][m];
//         for(int i =0;i<n;i++){
//             Arrays.fill(dp[i],Integer.MIN_VALUE);
//         }
//         return f(0,0,triangle,dp);
//     }
// }