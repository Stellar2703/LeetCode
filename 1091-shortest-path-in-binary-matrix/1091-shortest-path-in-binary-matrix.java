class Solution {
    class Pair {
        int x;
        int y;
        int dist;

        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        int m = grid.length;
        Queue<Pair> q = new LinkedList<>();
        int drow[] = { 0, 1, 0, -1, -1, 1, -1, 1 };
        int dcol[] = { -1, 0, 1, 0, -1, -1, 1, 1 };
        q.offer(new Pair(0, 0, 1));
        grid[0][0]=1;
        while (!q.isEmpty()) {
            int row = q.peek().x;
            int col = q.peek().y;
            int dist = q.peek().dist;
            q.poll();
            if (row == n - 1 && col == m - 1)
                return dist;
            for (int i = 0; i < 8; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 0) {
                    q.offer(new Pair(nrow, ncol, dist + 1));
                    grid[nrow][ncol] = 1;
                }
            }
        }
        return -1;
    }
}