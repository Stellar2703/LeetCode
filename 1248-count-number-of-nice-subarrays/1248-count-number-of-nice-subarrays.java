class Solution {
    public int f(int[] nums,int k){
        int odd = 0,l=0,count=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]%2==1) odd++;
            while(odd>k){
                if(nums[l]%2==1) odd--;
                l++;
            }
            count+=(r-l+1);
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return f(nums,k)-f(nums,k-1);
    }
}