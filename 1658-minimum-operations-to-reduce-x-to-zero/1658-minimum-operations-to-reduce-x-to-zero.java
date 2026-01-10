class Solution {
    public int minOperations(int[] nums, int x) {
        int sum =0,l=0,ans=-1,totalsum = 0,calc = 0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
        }
        totalsum = sum-x;
        for(int  r=0;r<nums.length;r++){
            calc+= nums[r];
            while(calc>totalsum && l<=r){
                calc-=nums[l];
                l++;
            }
            if(calc == totalsum) ans = Math.max(ans,r-l+1);
        }
        return ans == -1 ? -1 : nums.length-ans;
    }
}