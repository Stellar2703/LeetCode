class Solution {
    public int numOfPairs(String[] nums, String target) {
        int n = nums.length;
        int count =0;
        int tar = target.length();
        HashMap<String,Integer> mp = new HashMap<>();
        for(int i =0;i<n;i++){
            int len = nums[i].length();

            if(tar>len && nums[i].equals(target.substring(0,len)) && mp.containsKey(target.substring(len,tar))){
                count+=mp.get(target.substring(len,tar));
            }

            if(tar>len && nums[i].equals(target.substring(tar-len,tar)) && mp.containsKey(target.substring(0,tar-len))){
                count+=mp.get(target.substring(0,tar-len));
            }

            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}