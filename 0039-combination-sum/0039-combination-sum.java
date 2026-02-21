class Solution {
    private void f(int index, int[] nums, int target, int sum, List<List<Integer>> ans,
            List<Integer> temp) {
        if (sum == target)
            ans.add(new ArrayList<>(temp));
        if (index == nums.length)
            return;
        if(sum>target) return;

        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            temp.add(nums[i]);
            f(i, nums, target, sum, ans, temp);
            sum -= nums[i];
               temp.remove(temp.size() - 1);
            
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(0, candidates, target, 0, ans, temp);
        return ans;
    }
}