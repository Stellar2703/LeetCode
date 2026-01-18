class Solution {
    public void getsubsets( int[] nums ,List<List<Integer>> ans, ArrayList<Integer> temp , int index){
        if(index ==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // pick 
        temp.add(nums[index]);
        getsubsets(nums,ans,temp,index+1);

        // remove the picked element
        temp.remove(temp.size()-1);
        getsubsets(nums,ans,temp,index+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        getsubsets(nums,ans,temp,0);
        return ans;
    }
}