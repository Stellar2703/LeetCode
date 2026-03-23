class Solution {
    public int repeatedNTimes(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int count = 0;
        int ans = -1;
        if(a!=b && b!=c && c!= a){
            for(int i =3;i<nums.length;i++){
                if(count==0){
                    count = 1;
                    ans= nums[i];
                }
                else if(ans == nums[i]){
                    return ans;
                }
                else count --;
            }
            return ans;
        }
        count =0;
        ans = -1;
         for(int i =0;i<3;i++){
                if(count==0){
                    count = 1;
                    ans = nums[i];
                }
                else if(ans == nums[i]){
                    return ans;
                }
                else count --;
            }
        return ans;
    }
}