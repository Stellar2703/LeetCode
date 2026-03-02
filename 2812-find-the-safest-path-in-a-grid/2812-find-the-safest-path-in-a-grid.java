class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    class Pairs {
        int row;
        int col;
        int maxdist;

        Pairs(int row, int col, int maxdist) {
            this.row = row;
            this.col = col;
            this.maxdist = maxdist;
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int m = grid.get(0).size();

        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        // Initialize distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1; // not visited
            }
        }

        // Push all thieves into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new Pair(i, j));
                }
            }
        }

        int[] drow = { 0, 1, 0, -1 };
        int[] dcol = { 1, 0, -1, 0 };

        // Multi-source BFS
        while (!q.isEmpty()) {

            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;

            for (int k = 0; k < 4; k++) {

                int nrow = row + drow[k];
                int ncol = col + dcol[k];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m
                        && dist[nrow][ncol] == -1) {

                    dist[nrow][ncol] = dist[row][col] + 1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        // Use Dijkstra

        PriorityQueue<Pairs> qu = new PriorityQueue<>((a, b) -> b.maxdist - a.maxdist);
        qu.offer(new Pairs(0, 0, dist[0][0]));

        int[][] maxSafeness = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(maxSafeness[i], -1);
        maxSafeness[0][0] = dist[0][0];

        while (!qu.isEmpty()) {
            Pairs curr = qu.poll();
            int row = curr.row;
            int col = curr.col;
            int safeness = curr.maxdist;

            if (row == n - 1 && col == m - 1)
                return safeness;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m) {
                    int newSafeness = Math.min(safeness, dist[nrow][ncol]);
                    if (newSafeness > maxSafeness[nrow][ncol]) {
                        maxSafeness[nrow][ncol] = newSafeness;
                        qu.offer(new Pairs(nrow, ncol, newSafeness));
                    }
                }
            }
        }
        return 0;
    }
}