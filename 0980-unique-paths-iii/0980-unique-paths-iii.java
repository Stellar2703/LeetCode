class Solution {
    int end_row;
    int end_col;
    int vis_count;
    int[][] vis;
    int ans  =0;
    private void f(int row,int col,int[][] grid,int count){
        if(end_row==row && end_col==col && vis_count==count){
            ans++;
            return;
        }

        int[] drow = {0,1,0,-1};
        int[] dcol = {-1,0,1,0};
        for(int i=0;i<4;i++){
            int nrow  = row+drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]!= -1 && vis[nrow][ncol]!=1){
                vis[nrow][ncol]=1;
                f(nrow,ncol,grid,count+1);
                vis[nrow][ncol]=0;
            }
        }
    }
    public int uniquePathsIII(int[][] grid) {
        int n  = grid.length;
        int m = grid[0].length;
        int start_row = 0;
        int start_col = 0;
        vis = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    start_row = i;
                    start_col = j;
                }
                if(grid[i][j]==2){
                    end_row = i;
                    end_col = j;
                }
                if(grid[i][j]!=-1){
                    vis_count++;
                }
                
            }
        }
        vis[start_row][start_col]=1;
        f(start_row,start_col,grid,1);
        return ans;
    }
}