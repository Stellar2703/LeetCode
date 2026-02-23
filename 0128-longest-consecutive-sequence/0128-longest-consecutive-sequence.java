class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> mp = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            mp.add(nums[i]);
        }
        if(nums.length==0) return 0;
        int max = 1;
        for(int i=0;i<nums.length;i++){
            int length = 1;
            if(!mp.contains(nums[i]-1)){
                mp.add(nums[i]);
                int num = nums[i]+1;
                while(mp.contains(num)){
                    length++;
                    max = Math.max(length,max);
                    num++;
                }
            }
        }
        return max;
    }
}