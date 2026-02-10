class Solution {
    public int f(int[] nums,int index,int target,int[][]dp,int add){
        if (target + add < 0 || target + add >= dp[0].length) return 0;
        if(index<0){
            if(target == 0){
                return 1;
            }
            else return 0;
        }
        if(dp[index][target+add]!=Integer.MIN_VALUE) return dp[index][target+add];
        int pick = f(nums,index-1,target-nums[index],dp,add) ;
        int not_pick = f(nums,index-1,target+nums[index],dp,add);
        return dp[index][target+add] = pick+not_pick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum= 0;
        for(int x : nums) sum+=x;
        int[][] dp = new int[nums.length][2*sum+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<2*sum+1;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int add = sum;
        return f(nums,nums.length-1,target,dp,add);
    }
}




// class Solution {
//     public void f(int[] nums,int index,int target,int[] count){
//         if(index<0){
//             if(target == 0) count[0]++;
//             return;
//         }
//         f(nums,index-1,target-nums[index],count);
//         f(nums,index-1,target+nums[index],count);
//     }
//     public int findTargetSumWays(int[] nums, int target) {
//         int[] count = new int[1];
//         f(nums,nums.length-1,target,count);
//         return count[0];
//     }
// }