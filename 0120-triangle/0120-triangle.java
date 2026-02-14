class Solution {
    public int f(int i,int j ,List<List<Integer>> arr,Integer[][]dp){
        if(i>=arr.size() || j>=arr.get(i).size()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int left = arr.get(i).get(j) + f(i+1,j,arr,dp);
        int right = arr.get(i).get(j) + f(i+1,j+1,arr,dp);

        return dp[i][j] = Math.min(left,right);
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp  =new Integer[triangle.size()][triangle.get(triangle.size()-1).size()];
        return f(0,0,triangle,dp);
    }
}