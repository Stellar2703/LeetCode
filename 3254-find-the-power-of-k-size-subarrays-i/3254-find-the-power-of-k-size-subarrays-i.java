class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int count = 0 , l=0;
        int [] ans = new int [nums.length-k+1];
        for (int i = 1;i<k;i++){
            if(nums[i-1]+1==nums[i]) count++;
        }
        ans[l++] = (count == k-1) ? nums[k-1] : -1;
        for(int r = k;r<nums.length;r++){
            if(nums[l-1]+1==nums[l]) count--;
            if(nums[r-1]+1==nums[r]) count++;
            ans[l++] = (count==k-1) ? nums[r] : -1;
        }
    return ans;
    }
}



// class Solution {
    // public int[] resultsArray(int[] nums, int k) {
        // int r = k-1,l=0;
        // boolean is_valid = true;
        // int [] ans = new int[nums.length-k+1];
        // while(r<nums.length){
            // for(int i = l+1;i<=r;i++){
                // if(nums[i-1]+1 != nums[i]){
                    // is_valid = false;
                    // break;
                // }
            // }
            // if(is_valid) ans[l++] = nums[r];
            // else ans[l++] = -1;
            // is_valid = true; 
            // r++;
        // }
        // return ans;
    // }
// }