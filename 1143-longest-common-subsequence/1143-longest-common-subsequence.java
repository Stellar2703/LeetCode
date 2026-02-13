class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Base case already handled (last row and column are 0)

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }

            }
        }

        return dp[0][0];
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