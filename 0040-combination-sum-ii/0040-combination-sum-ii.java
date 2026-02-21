import java.util.*;

class Solution {
    private void f(int index, int[] nums, int target, int sum, HashSet<List<Integer>> ans, List<Integer> temp) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target) return;

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            if (sum + nums[i] > target) break; // Early pruning

            temp.add(nums[i]);
            f(i + 1, nums, target, sum + nums[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // Sort to handle duplicates
        HashSet<List<Integer>> ans = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        f(0, candidates, target, 0, ans, temp);
        return new ArrayList<>(ans);
    }
}