class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int count =0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) count++;
        }
        int l=0;
        int times = 0 ;
        for(int i=0;i<count;i++){
            if(nums[i]==1) times++;
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(count-times,ans);
        for(int i=count;i<2*n;i++){
            if(nums[l%n]==1) times--;
            if(nums[i%n]==1) times++;
            l++;
            ans = Math.min(count-times,ans);
        }
    return ans;
    }
}