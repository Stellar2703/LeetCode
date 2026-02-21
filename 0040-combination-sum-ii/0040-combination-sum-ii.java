class Solution {
    private void f(int index, int[] nums, int target, int sum, HashSet<List<Integer>> ans,
            List<Integer> temp) {
        if (sum == target)
            ans.add(new ArrayList<>(temp));
        if (index == nums.length)
            return;
        if(sum>target) return;

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            sum += nums[i];
            temp.add(nums[i]);
            f(i+1, nums, target, sum, ans, temp);
            sum -= nums[i];
            temp.remove(temp.size() - 1); 
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
         Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        f(0, candidates, target, 0, ans, temp);
        return new ArrayList<>(ans);
    }
}

