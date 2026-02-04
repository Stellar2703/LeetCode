class Pair {
    int row;
    int col;

    Pair(int _row, int _col) {
        this.row = _row;
        this.col = _col;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        // Step 1: Initialization
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new Pair(i, j));   // multi-source BFS
                } else {
                    dist[i][j] = -1;          // unvisited
                }
            }
        }

        int[] drow = {0, 1, 0, -1};
        int[] dcol = {-1, 0, 1, 0};

        // Step 2: BFS
        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nrow = p.row + drow[d];
                int ncol = p.col + dcol[d];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    dist[nrow][ncol] == -1) {

                    dist[nrow][ncol] = dist[p.row][p.col] + 1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        return dist;
    }
}
