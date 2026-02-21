// class Solution {
//     private void f(int index, int[] nums, int target, int sum, List<List<Integer>> ans,
//             List<Integer> temp) {
//         if (sum == target)
//             ans.add(new ArrayList<>(temp));
//         if (index == nums.length)
//             return;
//         if(sum>target) return;

//         for (int i = index; i < nums.length; i++) {
//             sum += nums[i];
//             temp.add(nums[i]);
//             f(i, nums, target, sum, ans, temp);
//             sum -= nums[i];
//             temp.remove(temp.size() - 1);
            
//         }

//     }

//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> temp = new ArrayList<>();
//         f(0, candidates, target, 0, ans, temp);
//         return ans;
//     }
// }


class Solution {
    private void f(int start, int[] nums, int target,
                   List<List<Integer>> ans, List<Integer> temp) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (nums[i] > target) break;   // 🔥 pruning

            temp.add(nums[i]);
            f(i, nums, target - nums[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);  // 🔥 important
        List<List<Integer>> ans = new ArrayList<>();
        f(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}