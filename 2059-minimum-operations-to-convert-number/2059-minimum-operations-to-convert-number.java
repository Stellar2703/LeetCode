class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int level = 0;
        int[] vis = new int[1001];
        vis[start] = 1;
        int n = nums.length;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                if (node == goal)
                    return level;

                for (int j = 0; j < n; j++) {

                    if (nums[j] + node == goal)
                        return level + 1;

                    if (nums[j] + node >= 0 && nums[j] + node <= 1000
                            && vis[nums[j] + node] != 1) {
                        q.offer(nums[j] + node);
                        vis[nums[j] + node] = 1;
                    }

                    if (node - nums[j] == goal)
                        return level + 1;

                    if (node - nums[j] >= 0 && node - nums[j] <= 1000
                            && vis[node - nums[j]] != 1) {
                        q.offer(node - nums[j] );
                        vis[node - nums[j]] = 1;
                    }

                    if ((nums[j] ^ node) == goal)
                        return level + 1;

                    if ((nums[j] ^ node) >= 0 && (nums[j] ^ node) <= 1000
                            && vis[nums[j] ^ node] != 1) {
                        q.offer(nums[j] ^ node);
                        vis[nums[j] ^ node] = 1;
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
