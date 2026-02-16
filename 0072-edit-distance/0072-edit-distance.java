class Solution {
    public int f(String s1,String s2,int i,int j,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return 0 + f(s1,s2,i-1,j-1,dp);
        int insert  = 1 + f(s1,s2,i,j-1,dp);
        int replace = 1 + f(s1,s2,i-1,j-1,dp);
        int delete  = 1 + f(s1,s2,i-1,j,dp);

        return dp[i][j] = Math.min(insert,Math.min(replace,delete));
    }
    public int minDistance(String word1, String word2) {
        int[][]dp = new int [word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return f(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
}