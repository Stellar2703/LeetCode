class Solution {
    public void dfs(int row,int col,int[][] grid){
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        grid[row][col]=1;
        for(int i =0;i<4;i++){
            int nrow = drow[i]+row;
            int ncol = dcol[i]+col;
            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]==0){
                dfs(nrow,ncol,grid);
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[0][i]==0) dfs(0,i,grid);
            if(grid[n-1][i]==-0) dfs(n-1,i,grid);
        }

        for(int i =0;i<n;i++){
            if(grid[i][0]==0) dfs(i,0,grid);
            if(grid[i][m-1]==0) dfs(i,m-1,grid);
        }
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
}