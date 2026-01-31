class Solution {
    public int dfs(int i,int j,int[][] vis , int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        vis[i][j] =1;
        int [] drow = {1,0,-1,0};
        int [] dcol = {0,-1,0,1};
        int count =1;
        for(int p=0;p<4;p++){
            int nrow = i+drow[p];
            int ncol = j+dcol[p];
            if(nrow>=0 && nrow<=n-1 && ncol>=0 && ncol<=m-1 && grid[nrow][ncol]==1 && vis[nrow][ncol]==0 ){
                
                count += dfs(nrow,ncol,vis,grid);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int area =0;
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    area = Math.max(area,dfs(i,j,vis,grid));
                }
            }
        }
            return area;
    }
}