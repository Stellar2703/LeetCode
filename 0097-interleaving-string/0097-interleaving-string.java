class Solution {
    private Boolean f(int i,int j,String s1,String s2,String s3,Boolean[][]dp){
        if (s1.length() + s2.length() != s3.length()) return false;
        if(i+j == s3.length()) return true;
        if(dp[i][j]!=null) return dp[i][j];
        int k = i+j;

        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
            if(f(i+1,j,s1,s2,s3,dp)) return dp[i][j] = true;
        }

        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            if(f(i,j+1,s1,s2,s3,dp)) return dp[i][j] =true;
        }

        return dp[i][j] = false;

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean [][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return f(0,0,s1,s2,s3,dp);
    }
}