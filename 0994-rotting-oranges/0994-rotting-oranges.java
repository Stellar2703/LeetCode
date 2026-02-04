class Pair {
    int row;
    int col;

    Pair(int _row, int _col) {
        this.row = _row;
        this.col = _col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int[] drow = {0,1,0,-1};
        int[] dcol = {-1,0,1,0};
        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            for(int i =0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol <m  && grid[nrow][ncol]==1){
                    q.offer(new Pair(nrow, ncol));
                    grid[nrow][ncol]=2;
                    fresh--;
                }
            }
        }
            minutes++;

        }
        return fresh == 0 ? minutes-1 : -1;
    }
}