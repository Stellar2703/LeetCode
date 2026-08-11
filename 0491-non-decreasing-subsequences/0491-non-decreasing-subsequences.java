class Solution {

    List<List<Integer>> ans;
    HashSet<List<Integer>> hs;
    public void f(int index,int[] nums,List<Integer> temp){
        if(temp.size()>=2) hs.add(new ArrayList<>(temp));
        if(index==nums.length) return;

        if(temp.isEmpty() || temp.get(temp.size()-1)<= nums[index]){
            temp.add(nums[index]);
            f(index+1,nums,temp);
            temp.remove(temp.size()-1);
        }
        f(index+1,nums,temp);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        hs = new HashSet<>();
        ans = new ArrayList<>();
        f(0,nums,new ArrayList<>());
        for(List<Integer> a : hs){
            ans.add(a);
        }
        return ans;
    }
}