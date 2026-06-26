class Solution {

    private int next(int i, int[] nums) {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }

    public boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) continue;

            int dir = nums[i] > 0 ? 1 : -1;

            int slow = i, fast = i;

            while (true) {

                slow = next(slow, nums);
                if ((nums[slow] > 0 ? 1 : -1) != dir) break;

                fast = next(fast, nums);
                if ((nums[fast] > 0 ? 1 : -1) != dir) break;

                fast = next(fast, nums);
                if ((nums[fast] > 0 ? 1 : -1) != dir) break;

                if (slow == fast) {
                    if (slow == next(slow, nums)) break;
                    return true;
                }
            }

            int curr = i;
            while (nums[curr] != 0 && (nums[curr] > 0 ? 1 : -1) == dir) {
                int nxt = next(curr, nums);
                nums[curr] = 0;
                curr = nxt;
            }
        }

        return false;
    }
}