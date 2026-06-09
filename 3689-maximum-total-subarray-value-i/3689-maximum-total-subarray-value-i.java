class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int a :nums){
            min = Math.min(a,min);
            max = Math.max(a,max);
        }
        return k*(max-min);
    }
}