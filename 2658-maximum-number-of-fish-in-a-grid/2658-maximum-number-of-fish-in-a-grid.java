class Solution {

    private int f(int row, int col, int[][] grid, int[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;

        int sum = grid[row][col];

        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                grid[nrow][ncol] > 0 &&
                vis[nrow][ncol] == 0) {

                sum += f(nrow, ncol, grid, vis);
            }
        }

        return sum;
    }

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && vis[i][j] == 0) {
                    ans = Math.max(ans, f(i, j, grid, vis));
                }
            }
        }

        return ans;
    }
}