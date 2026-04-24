class Solution {

    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int good = 0,time = 0,rot=0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    good++;
                }
            }
        }
        if(good==0) return 0;

        while(!q.isEmpty()){
            int size  =q.size();
            // Syqem.out.println(size);
            for(int i =0;i<size;i++){
                Pair p = q.poll();
                int[] drow = {-1,0,1,0};
                int[] dcol = {0,1,0,-1};
                for(int j=0;j<4;j++){
                    int nrow = p.row+drow[j];
                    int ncol = p.col+dcol[j];
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1){
                        q.offer(new Pair(nrow,ncol));
                        good--;
                        grid[nrow][ncol]=2;
                    }
                }
            }
            time++;
        }
        return good==0 ? time-1 : -1;
    }
}