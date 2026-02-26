        class Solution {
            public int f(int index,int[] nums,int previndex,int[][] dp){
                if(index==nums.length) return 0;
                if(dp[index][previndex+1]!= -1) return dp[index][previndex+1];
                int not_pick = f(index+1,nums,previndex,dp);
                int pick = 0;
                if(previndex == -1 || nums[index] > nums[previndex]){
                    pick = 1+f(index+1,nums,index,dp);
                }
                return dp[index][previndex+1] = Math.max(pick,not_pick);
            }
            public int lengthOfLIS(int[] nums) {
                int[][] dp = new int[nums.length][nums.length+1];
                for(int i=0;i<nums.length;i++){
                    Arrays.fill(dp[i],-1);
                }
                return f(0,nums,-1,dp);
            }
        }