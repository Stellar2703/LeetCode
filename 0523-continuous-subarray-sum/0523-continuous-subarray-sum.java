class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        int prefix = 0;
        for(int i =0;i<nums.length;i++){
            prefix+= nums[i];
            int rem = prefix%k;
            if(mp.containsKey(rem)){
                if(i-mp.get(rem)>1)return true;
            }
            else{
                mp.put(rem,i);
            }
        }
        return false;
    }
}