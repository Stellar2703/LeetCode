class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0 && vis[i][0] != 1)
                dfs(grid, i, 0, vis);
            if (grid[i][m - 1] == 0 && vis[i][m - 1] != 1)
                dfs(grid, i, m - 1, vis);
        }
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 0 && vis[0][i] != 1)
                dfs(grid, 0, i, vis);
            if (grid[n - 1][i] == 0 && vis[n - 1][i] != 1)
                dfs(grid, n - 1, i, vis);
        }
        // afer floodfill the edges --- count
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0 && vis[i][j] != 1) {
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int i, int j, int[][] vis) {
        vis[i][j] = 1;
        int[] drow = { 0, -1, 0, 1 };
        int[] dcol = { 1, 0, -1, 0 };
        for (int p = 0; p < 4; p++) {
            int nrow = i + drow[p];
            int ncol = j + dcol[p];
            if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && vis[nrow][ncol] != 1
                    && grid[nrow][ncol] == 0)
                dfs(grid, nrow, ncol, vis);
        }
    }
}