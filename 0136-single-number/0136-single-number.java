class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer,Integer> a:mp.entrySet()){
            if (a.getValue()==1){
                return a.getKey();
            }
        }
        return 0;
    }
}