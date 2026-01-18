class Solution {
    public void subset(int [] nums,List<List<Integer>> ans,List<Integer> temp, int index ){
        if(index == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // for pick
        temp.add(nums[index]);
        subset(nums,ans,temp,index+1);

        // not pick so pop back the picked element
        temp.remove(temp.size()-1);
        while(index+1<=nums.length-1 && nums[index+1]==nums[index]) index++;
        subset(nums,ans,temp,index+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums,ans,temp,0);
        return ans;
    }
}