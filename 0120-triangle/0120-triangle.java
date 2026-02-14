class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[][] dp = new int[n][m];
        for(int i=0;i<m;i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i = n-2;i>=0;i--){
            for(int j = 0 ;j<=i;j++){
                int right = triangle.get(i).get(j) + dp[i+1][j+1];
                int left = triangle.get(i).get(j)+dp[i+1][j];
                dp[i][j] = Math.min(right,left);
            }
        }
        return dp[0][0];
    }
}


// class Solution {
//     public int f(int i,int j ,List<List<Integer>> arr,Integer[][]dp){
//         if(i>=arr.size() || j>=arr.get(i).size()) return 0;
//         if(dp[i][j]!=null) return dp[i][j];
//         int left = arr.get(i).get(j) + f(i+1,j,arr,dp);
//         int right = arr.get(i).get(j) + f(i+1,j+1,arr,dp);

//         return dp[i][j] = Math.min(left,right);
        
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         Integer[][] dp  =new Integer[triangle.size()][triangle.get(triangle.size()-1).size()];
//         return f(0,0,triangle,dp);
//     }
// }