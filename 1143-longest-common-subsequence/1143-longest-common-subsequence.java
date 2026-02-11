class Solution {
    public int f(int fir,int sec,String s1,String s2,int[][] dp){
        if(fir >= s1.length() || sec>=s2.length()) return 0;
        if(dp[fir][sec]!=-1) return dp[fir][sec];
        else if (s1.charAt(fir)==s2.charAt(sec)){
            dp[fir][sec] =  1 + f(fir+1,sec+1,s1,s2,dp);
            return dp[fir][sec];
        }
        else{
            dp[fir][sec] = Math.max(f(fir+1,sec,s1,s2,dp),f(fir,sec+1,s1,s2,dp));
            return dp[fir][sec];
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][]dp = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,0,text1,text2,dp);
    }
}




// class Solution {
//     public int f(int fir,int sec,String s1,String s2){
//         if(fir >= s1.length() || sec>=s2.length()) return 0;
//         else if (s1.charAt(fir)==s2.charAt(sec))
//             return 1 + f(fir+1,sec+1,s1,s2);
//         else
//             return Math.max(f(fir+1,sec,s1,s2),f(fir,sec+1,s1,s2));
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         return f(0,0,text1,text2);
//     }
// }