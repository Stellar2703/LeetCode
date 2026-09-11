class Solution {
    int[][] matrix;

    private boolean dfs(int i, int j, int row, int col, int[][] vis) {
        if (i == row) {
            return true;
        }

        vis[i][j] = 1;

        int[] drow = { 0, 1, 0, -1 };
        int[] dcol = { 1, 0, -1, 0 };

        for (int k = 0; k < 4; k++) {
            int nrow = i + drow[k];
            int ncol = j + dcol[k];

            if (nrow >= 1 && ncol >= 1 &&
                    nrow <= row && ncol <= col &&
                    matrix[nrow][ncol] == 0 &&
                    vis[nrow][ncol] == 0) {

                if (dfs(nrow, ncol, row, col, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0, high = cells.length;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;

            matrix = new int[row + 1][col + 1];

            for (int i = 0; i < mid; i++) {
                matrix[cells[i][0]][cells[i][1]] = 1;
            }

            boolean reachable = false;

            for (int j = 1; j <= col; j++) {
                int[][] vis = new int[row + 1][col + 1];

                if (matrix[1][j] == 0 && dfs(1, j, row, col, vis)) {
                    reachable = true;
                    break;
                }
            }

            if (reachable) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;

    }
}