    class Solution {
        private long f(int index,int[][] arr,long[] dp){
            if(index>=arr.length) return 0;
            if(dp[index]!=-1) return dp[index];
            long solve = 0;
            long skip  = 0;
            solve = arr[index][0] + f(index+arr[index][1]+1,arr,dp);
            skip = 0+f(index+1,arr,dp);

            return dp[index]=Math.max(solve,skip);
        }
        public long mostPoints(int[][] questions) {
            long[] dp = new long[questions.length];
            Arrays.fill(dp,-1);
            return f(0,questions,dp);
        }
    }