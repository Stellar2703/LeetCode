class Solution {
    public long countSubarrays(int[] nums, int k) {
        long num = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            num = Math.max(num,nums[i]);
        }
        long count =0,sub = 0;
        int l=0;
        for(int i =0;i<n;i++){
            if(nums[i]==num)count ++;
            while(count>=k){
                if(nums[l]==num)count--;
                l++;
            }
            sub += (i-l+1);
        }
        long total  = (long)n*(n+1)/2;
        return total - sub;
    }

}