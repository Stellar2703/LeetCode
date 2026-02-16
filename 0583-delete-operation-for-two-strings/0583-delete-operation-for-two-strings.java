class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            dp[i][0] = i;
        }
        for(int i=0;i<=word2.length();i++){
            dp[0][i] = i;
        }


        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}




// class Solution {
//     int f(String s1,String s2,int i,int j,int[][] dp){
//         if(i<0) return j+1;
//         if(j<0) return i+1;
//         if(dp[i][j]!=-1) return dp[i][j];
//         if(s1.charAt(i)==s2.charAt(j)) return f(s1,s2,i-1,j-1,dp);

//         int fir = 1 + f(s1,s2,i-1,j,dp);
//         int sec = 1+ f(s1,s2,i,j-1,dp);
//         return dp[i][j] =  Math.min(fir,sec);
//     }
//     public int minDistance(String word1, String word2) {
//         int[][] dp = new int[word1.length()][word2.length()];
//         for(int i=0;i<word1.length();i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return f(word1,word2,word1.length()-1,word2.length()-1,dp);
//     }
// }