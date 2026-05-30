class Solution {
    int vis_count;
    int ans = 0;

    // private void f(int row, int col, int[][] grid, int count) {
    //     if (grid[row][col] == 2 && count == 0) {
    //         ans++;
    //         return;
    //     }

    //     int[] drow = { 0, 1, 0, -1 };
    //     int[] dcol = { -1, 0, 1, 0 };
    //     for (int i = 0; i < 4; i++) {
    //         int nrow = row + drow[i];
    //         int ncol = col + dcol[i];
    //         if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] != -1
    //                 && grid[nrow][ncol] != -2) {
    //             int temp = grid[nrow][ncol];
    //             grid[nrow][ncol] = -2;
    //             f(nrow, ncol, grid, count - 1);
    //             grid[nrow][ncol] = temp;
    //         }
    //     }
    // }

    private void f(int row, int col, int[][] grid, int count) {

        if (grid[row][col] == 2) {
            if (count == 0)
                ans++;
            return;
        }

        int temp = grid[row][col];
        grid[row][col] = -2; // mark CURRENT cell

        int[] drow = { 0, 1, 0, -1 };
        int[] dcol = { -1, 0, 1, 0 };

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && ncol >= 0 &&
                    nrow < grid.length && ncol < grid[0].length &&
                    grid[nrow][ncol] != -1 && grid[nrow][ncol] != -2) {

                f(nrow, ncol, grid, count - 1);
            }
        }

        grid[row][col] = temp; // unmark
    }

    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int start_row = 0;
        int start_col = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    start_row = i;
                    start_col = j;
                }
                if (grid[i][j] != -1) {
                    vis_count++;
                }

            }
        }
        grid[start_row][start_col] = -2;
        f(start_row, start_col, grid, vis_count - 1);
        return ans;
    }
}