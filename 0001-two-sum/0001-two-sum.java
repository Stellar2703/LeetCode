class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            int curr = nums[i];
            int remaining  =  target - curr;
            if (mp.containsKey(remaining)){
                ans[0] = i;
                ans[1] = mp.get(remaining);
                return ans;
            }
            mp.put(nums[i],i);
            
        }
        // for (Map.Entry <Integer,Integer> ele = mp.getSet();)
        return ans;
    }
}