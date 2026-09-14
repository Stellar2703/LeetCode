class Solution {
    class Pair {
        int row;
        int col;
        int keyMask;

        Pair(int row, int col, int keyMask) {
            this.row = row;
            this.col = col;
            this.keyMask = keyMask;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();

        int startRow = 0;
        int startCol = 0;
        int totalKeys = 0;

        // Find starting position and number of keys
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = grid[i].charAt(j);

                if (c == '@') {
                    startRow = i;
                    startCol = j;
                }

                if (c >= 'a' && c <= 'f') {
                    totalKeys++;
                }
            }
        }

        // If there are k keys:
        // k = 3 -> target mask = 111
        int targetMask = (1 << totalKeys) - 1;

        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {1, 0, -1, 0};

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(startRow, startCol, 0));

        // visited[row][col][keyMask]
        boolean[][][] visited = new boolean[rows][cols][64];
        visited[startRow][startCol][0] = true;

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();

                // Have we collected every key?
                if (curr.keyMask == targetMask) {
                    return level;
                }

                for (int d = 0; d < 4; d++) {
                    int nRow = curr.row + dRow[d];
                    int nCol = curr.col + dCol[d];

                    // Outside grid
                    if (nRow < 0 || nRow >= rows ||
                        nCol < 0 || nCol >= cols) {
                        continue;
                    }

                    char cell = grid[nRow].charAt(nCol);

                    // Wall
                    if (cell == '#') {
                        continue;
                    }

                    int newMask = curr.keyMask;

                    // If it's a lock
                    if (cell >= 'A' && cell <= 'F') {
                        int bit = cell - 'A';

                        // We don't have the corresponding key
                        if ((curr.keyMask & (1 << bit)) == 0) {
                            continue;
                        }
                    }

                    // If it's a key
                    if (cell >= 'a' && cell <= 'f') {
                        int bit = cell - 'a';

                        // Add the key
                        newMask = curr.keyMask | (1 << bit);
                    }

                    // Have we already visited this exact state?
                    if (visited[nRow][nCol][newMask]) {
                        continue;
                    }

                    visited[nRow][nCol][newMask] = true;

                    q.offer(new Pair(nRow, nCol, newMask));
                }
            }

            level++;
        }

        return -1;
    }
}