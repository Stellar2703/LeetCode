class Pair {
    int u;
    int v;

    Pair(int _u, int _v) {
        this.u = _u;
        this.v = _v;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        // first & last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                q.offer(new Pair(i, 0));
                vis[i][0] = 1;
            }
            if (grid[i][m - 1] == 1) {
                q.offer(new Pair(i, m - 1));
                vis[i][m - 1] = 1;
            }
        }

        // first & last row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                q.offer(new Pair(0, j));
                vis[0][j] = 1;
            }
            if (grid[n - 1][j] == 1) {
                q.offer(new Pair(n - 1, j));
                vis[n - 1][j] = 1;
            }
        }

        while (!q.isEmpty()) {
            int i = q.peek().u;
            int j = q.peek().v;

            q.poll();
            int[] drow = { 1, 0, -1, 0 };
            int[] dcol = { 0, -1, 0, 1 };
            for (int p = 0; p < 4; p++) {
                int nrow = i + drow[p];
                int ncol = j + dcol[p];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    q.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != vis[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}