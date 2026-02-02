class Pair {
    int row;
    int col;
    Pair(int _row, int _col) {
        this.row = _row;
        this.col = _col;
    }
}

class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        // Top & Bottom row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                q.offer(new Pair(0, j));
                vis[0][j] = 1;
            }
            if (board[n - 1][j] == 'O') {
                q.offer(new Pair(n - 1, j));
                vis[n - 1][j] = 1;
            }
        }

        // Left & Right column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                q.offer(new Pair(i, 0));
                vis[i][0] = 1;
            }
            if (board[i][m - 1] == 'O') {
                q.offer(new Pair(i, m - 1));
                vis[i][m - 1] = 1;
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // BFS
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int row = cur.row;
            int col = cur.col;

            board[row][col] = 'T'; // mark safe

            for (int k = 0; k < 4; k++) {
                int nrow = row + drow[k];
                int ncol = col + dcol[k];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m &&
                    board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0) {

                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        // Final conversion
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}
