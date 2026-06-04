class NumMatrix {
    private int[][] ans;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int top = 0;
                int left = 0;
                int extra = 0;
                if (i > 0) {
                    top = ans[i - 1][j];
                }
                if (j > 0) {
                    left = ans[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    extra = ans[i - 1][j - 1];
                }

                ans[i][j] = matrix[i][j] +top + left - extra;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int row = 0;
        int col = 0;
        int extra = 0;
        if (row1 > 0) {
            row = ans[row1 - 1][col2];
        }
        if (col1 > 0) {
            col = ans[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            extra = ans[row1 - 1][col1 - 1];
        }
        return (ans[row2][col2] - row - col + extra);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */