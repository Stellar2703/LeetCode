class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0,max = 0;
        for(int r=0;r<nums.length;r++){
            while(l<r && nums[l] +k < nums[r]-k){
                l++;
            }
                max = Math.max(max,r-l+1);
        }
        return max;
    }
}