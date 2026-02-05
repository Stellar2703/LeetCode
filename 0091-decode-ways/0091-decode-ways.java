class Solution {
    public int f(int start,String s,int [] dp){
        if(start==s.length())return 1;
        if(s.charAt(start)=='0') return 0;
        if (dp[start]!=-1) return dp[start];
        dp[start] = f(start+1,s,dp);
        if(start+1<s.length() && Integer.parseInt(s.substring(start,start+2))<=26){
            dp[start]+= f(start+2,s,dp);
        }
        return dp[start];
    }
    public int numDecodings(String s) {
        int [] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return f(0,s,dp);
        // return dp[0];
    }
}



// class Solution {
//     public int f(int start,String s){
//         if(start==s.length()) return 1;
//         if(s.charAt(start)=='0') return 0;

//         int pick = f(start+1,s);
//         if(start+1<=s.length()-1 && Integer.parseInt(s.substring(start,start+2))<=26){
//             pick += f(start+2,s);
//         }

//         return pick;

//     }
//     public int numDecodings(String s) {
//         return f(0,s);
//     }
// }