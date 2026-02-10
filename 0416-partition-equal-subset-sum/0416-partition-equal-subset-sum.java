class Solution {
    public boolean f(int[] nums,int index,int target,int[][] dp){
        if(target == 0 )return true;
        if(index==0) return target == nums[0];
        if (dp[index][target]!=-1) return dp[index][target]==1;
        boolean not_pick = f(nums,index-1,target,dp);
        boolean pick = false;
        if(nums[index]<=target){
            pick = f(nums,index-1,target-nums[index],dp);
        }
        dp[index][target] =  pick || not_pick ? 1 : 0;
        return pick || not_pick;
    }
    public boolean canPartition(int[] nums) {
        int sum =0,target=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==0){
            target = sum/2;
            int[][] dp = new int[nums.length][target+1];
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<target+1;j++){
                    dp[i][j] = -1;
                }
            }   
            return f(nums,nums.length-1,target,dp);
        }
        return false;
    }
}





// class Solution {
//     public boolean f(int[] nums,int index,int target){
//         if(target == 0 )return true;
//         if(index==0) return target == nums[0];

//         boolean not_pick = f(nums,index-1,target);
//         boolean pick = false;
//         if(nums[index]<=target){
//             pick = f(nums,index-1,target-nums[index]);
//         }
//         return pick || not_pick;
//     }
//     public boolean canPartition(int[] nums) {
//         int sum =0,target=0;
//         for(int i=0;i<nums.length;i++){
//             sum+=nums[i];
//         }
//         if(sum%2==0){
//             target = sum/2;
//             return f(nums,nums.length-1,target);
//         }
//         return false;
//     }
// }