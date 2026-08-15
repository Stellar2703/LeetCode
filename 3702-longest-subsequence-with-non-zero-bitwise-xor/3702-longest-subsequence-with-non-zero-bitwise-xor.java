class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        long sum = nums[0];
        int count = nums[0];
        for(int r =1;r<n;r++){
            count = count ^ nums[r];  
            sum+=nums[r];
        }
        if(sum==0) return 0;
        return  count ==0 ? n-1 : n;
    }
}