class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int ans = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int r=0;r<n;r++){
            mp.putIfAbsent(nums[r],0);

            mp.put(nums[r],mp.get(nums[r])+1);
            while(mp.get(nums[r])>k){
                mp.put(nums[l],mp.get(nums[l])-1);
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}