class Solution {
    int f(String s1,String s2,int i, int j,int[][] dp){
        if(i<0){
            int sum =0;
            for(int x = j;x>=0;x--){
                sum = sum + s2.charAt(x);
            }
            return sum;
        }
        if(j<0) {
            int sum =0;
            for(int x = i;x>=0;x--){
                sum = sum + s1.charAt(x);
            }
            return sum;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return f(s1,s2,i-1,j-1,dp);

        return dp[i][j] = Math.min((int) s1.charAt(i) + f(s1,s2,i-1,j,dp),
                        (int) s2.charAt(j) + f(s1,s2,i,j-1,dp));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp =new int[s1.length()][s2.length()];
        for(int i=0;i<s1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return f(s1,s2,s1.length()-1,s2.length()-1,dp);
    }
}