class Solution {
   public void dfs(int[][] heights, int row, int col, HashSet<String> ocean) {
    String cell = row + "," + col;
    ocean.add(cell);

    int[] drow = {0, -1, 0, 1};
    int[] dcol = {1, 0, -1, 0};

    for (int i = 0; i < 4; i++) {
        int nrow = row + drow[i];
        int ncol = col + dcol[i];
        String neigh = nrow + "," + ncol;

        if (nrow >= 0 && ncol >= 0 && nrow < heights.length && ncol < heights[0].length &&
            heights[nrow][ncol] >= heights[row][col] && !ocean.contains(neigh) ){
            dfs(heights, nrow, ncol, ocean);
        }
    }
}

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> result = new ArrayList<>();
    if (heights == null || heights.length == 0) return result;

    int row = heights.length;
    int col = heights[0].length;

    HashSet<String> pacific = new HashSet<>();
    HashSet<String> atlantic = new HashSet<>();

    // DFS for Pacific (top row + left column)
    for (int i = 0; i < col; i++) dfs(heights, 0, i, pacific);
    for (int i = 0; i < row; i++) dfs(heights, i, 0, pacific);

    // DFS for Atlantic (bottom row + right column)
    for (int i = 0; i < col; i++) dfs(heights, row - 1, i, atlantic);
    for (int i = 0; i < row; i++) dfs(heights, i, col - 1, atlantic);

    // Add cells reachable by both oceans
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            String cell = i + "," + j;
            if (pacific.contains(cell) && atlantic.contains(cell)) {
                result.add(Arrays.asList(i, j));
            }
        }
    }

    return result;

    }
}