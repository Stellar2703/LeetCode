class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        int oneDigit = 0;
        int twoDigit = 0;
        for(int i=n-1;i>=0;i--){
            oneDigit = 0;
            twoDigit = 0;
            if(s.charAt(i)!='0'){
                oneDigit = dp[i+1];
                if(i<n-1 && Integer.parseInt(s.substring(i,i+2))<=26){
                    twoDigit = dp[i+2];
                }
            }
            dp[i] = oneDigit + twoDigit;
        }
        return dp[0];
    }
}




// class Solution {
//     public int f(int index, String s,int [] dp) {
//         if (index >= s.length())
//             return 1;
//         if (s.charAt(index) == '0')
//             return 0;

//         if(dp[index]!=-1) return dp[index];
//         int oneDigit = f(index + 1, s,dp);

//         int twoDigit = 0;
//         if (index < s.length() - 1) {
//             int num = (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0');
//             if (num <= 26) {
//                 twoDigit = f(index + 2, s,dp);
//             }
//         }

//         return dp[index] = oneDigit + twoDigit;
//     }

//     public int numDecodings(String s) {
//         int [] dp =  new int[s.length()];
//         Arrays.fill(dp,-1);
//         return f(0, s,dp); 
//     }
// }