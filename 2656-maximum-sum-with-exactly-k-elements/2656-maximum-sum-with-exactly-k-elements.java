class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = -1;
        for(int i:nums){
            if(max<i){
                max = i;
            }
        }
        int ans = 0;
        for(int i =0;i<k;i++){
            ans+=max;
            max+=1;
        }
        return ans;
    }
}