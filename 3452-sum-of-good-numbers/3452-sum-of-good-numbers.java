class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int n = nums.length,sum =0;
        for(int i =0;i<n;i++){
            boolean left = true, right =true;
            if(i-k>=0 && nums[i]<= nums[i-k]){
                left =false;
            }
            if(i+k<n && nums[i]<=nums[i+k]){
                right = false;
            }
            if(left && right){
                sum+=nums[i];
            }

        }
        return sum;
    }
}