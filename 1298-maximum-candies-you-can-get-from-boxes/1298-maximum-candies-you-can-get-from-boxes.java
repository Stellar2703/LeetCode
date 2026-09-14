class Solution {
    public int maxCandies(int[] status, int[] candies,
                          int[][] keys, int[][] containedBoxes,
                          int[] initialBoxes) {

        int ans = 0;
        int n = status.length;

        boolean[] have = new boolean[n];
        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        // Initially, we possess these boxes.
        for (int box : initialBoxes) {
            have[box] = true;

            // We can open it immediately if it is open.
            if (status[box] == 1) {
                q.offer(box);
            }
        }

        while (!q.isEmpty()) {
            int box = q.poll();

            if (vis[box]) {
                continue;
            }

            vis[box] = true;
            ans += candies[box];

            // Get keys from this box.
            for (int key : keys[box]) {
                status[key] = 1;

                // If we already have this box, we can now open it.
                if (have[key] && !vis[key]) {
                    q.offer(key);
                }
            }

            // Get boxes from this box.
            for (int newBox : containedBoxes[box]) {
                have[newBox] = true;

                // If the box is already open, process it.
                if (status[newBox] == 1 && !vis[newBox]) {
                    q.offer(newBox);
                }
            }
        }

        return ans;
    }
}
