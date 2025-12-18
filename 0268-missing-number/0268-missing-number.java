class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int i=1;i<=nums.length;i++){
            xor = xor ^ nums[i-1] ^ i;
        }
        return xor;
    }
}