// class Solution {
//     public int findUnsortedSubarray(int[] nums) {
//         Stack<Integer> stack = new Stack<>();
//         int st = nums.length, end = 0;

//         for (int i = 0; i < nums.length; i++) {
//             while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
//                 st = Math.min(st, stack.pop());
//             }
//             stack.push(i);
//         }

//         stack.clear();

//         for (int i = nums.length - 1; i >= 0; i--) {
//             while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
//                 end = Math.max(end, stack.pop());
//             }
//             stack.push(i);
//         }

//         if (end <= st) return 0;
//         return end - st + 1;
//     }
// }

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int max = nums[0];
        int min = nums[n-1];
        int start = -1, end = -2;

        for(int i = 1; i < n; i++){
            max = Math.max(max, nums[i]);
            if(nums[i] < max) end = i;
        }

        for(int i = n-2; i >= 0; i--){
            min = Math.min(min, nums[i]);
            if(nums[i] > min) start = i;
        }

        return end - start + 1;
    }
}