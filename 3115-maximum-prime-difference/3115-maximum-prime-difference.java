class Solution {
    static boolean[] prime = new boolean[101];

    static {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= 100; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 100; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public int maximumPrimeDifference(int[] nums) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (prime[nums[i]]) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        return last - first;
    }
}