class Solution {
    HashMap<Integer,Integer> mp = new HashMap<>();
    public int f(int i,int[] nums,int k){
        if(i == nums.length) return 1;

        int count  =0;
        count+= f(i+1,nums,k);
        if(!mp.containsKey(nums[i]-k) && !mp.containsKey(nums[i]+k)){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            count += f(i+1,nums,k);
            if(mp.get(nums[i])==1)mp.remove(nums[i]);
            else mp.put(nums[i],mp.get(nums[i])-1);
        }
        return count;
    }
    public int beautifulSubsets(int[] nums, int k) {
        return f(0,nums,k)-1;
    }
}