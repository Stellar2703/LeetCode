// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         int n = nums.length;
        
//         for (int i = 0; i < n; i++) {
//             if (i + 1 < n && nums[i] == nums[i + 1]) return nums[i];
//             if (i + 2 < n && nums[i] == nums[i + 2]) return nums[i];
//         }
        
//         return -1; // never reached
//     }
// }

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