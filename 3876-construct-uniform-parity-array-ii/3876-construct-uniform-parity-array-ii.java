class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int min = Integer.MAX_VALUE;
        int odd = 0;
        int even = 0;
        for(int i =0;i<n;i++){
            min = Math.min(nums1[i],min);
            if(nums1[i]%2==0) even++;
            else odd++;
        }
        if(odd== n || even == n) return true;

        if(min%2!=0){
            return true;
        }
        if(min%2==0){
            return false;
        }
        return false;
    }
}