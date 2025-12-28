class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        int [] ans = new int[n];
        for(int i =0;i<n;i++){
            ans[i] = suffix ;
            suffix = suffix*nums[i];
        }
        for (int i=n-1;i>=0;i--){
            ans[i] = ans[i]*prefix;
            prefix = prefix*nums[i];
        }
        return ans;
    }
}