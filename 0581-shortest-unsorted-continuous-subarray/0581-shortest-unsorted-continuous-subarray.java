class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int st = nums.length, end = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                st = Math.min(st, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                end = Math.max(end, stack.pop());
            }
            stack.push(i);
        }

        if (end <= st) return 0;
        return end - st + 1;
    }
}