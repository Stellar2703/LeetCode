class Solution {

    public void dfs(int i, int j, int[][] image, int oldColor, int newColor) {
        image[i][j] = newColor;

        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int p = 0; p < 4; p++) {
            int nrow = i + drow[p];
            int ncol = j + dcol[p];

            if (nrow >= 0 && nrow < image.length &&
                ncol >= 0 && ncol < image[0].length &&
                image[nrow][ncol] == oldColor) {

                dfs(nrow, ncol, image, oldColor, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];

        if (oldColor == color) return image;

        dfs(sr, sc, image, oldColor, color);
        return image;
    }
}
