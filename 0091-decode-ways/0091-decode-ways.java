class Solution {
    public int f(String s,int index,int[] dp){
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        if(dp[index]!=-1) return dp[index];
        int pick = f(s,index+1,dp);
        int picktwo=0;
        if(index+1<s.length() && Integer.parseInt(s.substring(index,index+2))<=26){
            picktwo = f(s,index+2,dp);
        }
        dp[index] = pick + picktwo;
        return dp[index];
    }
    public int numDecodings(String s) {
        int [] dp =  new int[s.length()];
        Arrays.fill(dp,-1);
        return f(s,0,dp);
    }
}



// class Solution {
//     public int f(String s,int index){
//         if(index==s.length()) return 1;
//         if(s.charAt(index)=='0') return 0;
//         int pick = f(s,index+1);
//         int picktwo = 0;
//         if(index+1<s.length() && Integer.parseInt(s.substring(index,index+2))<=26){
//             picktwo = f(s,index+2);
//         }

//         return pick+picktwo;
//     }
//     public int numDecodings(String s) {
//         return f(s,0);
//     }
// }