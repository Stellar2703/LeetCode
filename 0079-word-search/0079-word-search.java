class Pair {
    char letter;
    int row;
    int col;

    Pair(char letter, int row, int col) {
        this.letter = letter;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public boolean dfs(int index, String word, char[][] board,
                       int row, int col, int[][] vis) {

        if (index == word.length()) return true;

        int n = board.length;
        int m = board[0].length;

        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {

            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m
                    && vis[nrow][ncol] == 0
                    && board[nrow][ncol] == word.charAt(index)) {

                vis[nrow][ncol] = 1;

                if (dfs(index + 1, word, board, nrow, ncol, vis))
                    return true;

                vis[nrow][ncol] = 0; // backtrack
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == word.charAt(0)) {

                    vis[i][j] = 1;   // mark start

                    if (dfs(1, word, board, i, j, vis))
                        return true;

                    vis[i][j] = 0;   // backtrack start
                }
            }
        }

        return false;
    }
}