class Solution {
    public boolean f(int index, String s, List<String> words,int[] dp) {
        if (index == s.length()) return true;

        if (dp[index] != -1) return dp[index] == 1;

        for (String word : words) {
            if (index + word.length() <= s.length() &&
                s.substring(index, index + word.length()).equals(word)) {

                if (f(index + word.length(), s, words,dp)) {
                    dp[index] = 1;
                    return true;
                }
            }
        }

        dp[index] = 0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int [] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return f(0, s, wordDict,dp);
    }
}




// class Solution {
//     public boolean f(int index,String s,List<String> words){
//         if(index==s.length()) return true;

//         for(String word : words){
//             if(index + word.length() <= s.length() && s.substring(index,index+word.length()).equals(word)){
//                 if(f(index+word.length(),s,words))
//                     return true;
//             }
//         }
//         return false;
//     }
//     public boolean wordBreak(String s, List<String> wordDict) {
//         if(f(0,s,wordDict)){
//             return true;
//         }
//         return false;
//     }
// }