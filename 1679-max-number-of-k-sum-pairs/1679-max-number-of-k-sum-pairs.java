class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        int count =0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i =0;i<n;i++){
            if(mp.containsKey(k-nums[i]) && mp.get(k-nums[i])>0){
                count+=1;
                mp.put(k-nums[i],mp.get(k-nums[i])-1);
            }
            else{
                mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            }
        }
        return count;
    }
}