    class Solution {
        boolean status = true;
        public void dfs(int i,int j,int[][] grid1, int[][] grid2,int[][] vis){
            int n = grid1.length;
            int m = grid1[0].length;
            int drow[] = {1,0,-1,0};
            int dcol[] = {0,1,0,-1};
            vis[i][j] = 1;
            if(grid1[i][j] != 1) status = false;
            for(int k=0;k<4;k++){
                int nrow = i+drow[k];
                int ncol = j+dcol[k];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid2[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    if(grid1[nrow][ncol]!=1) status = false;
                    dfs(nrow,ncol,grid1,grid2,vis);
                }
            }
        }
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int n  = grid1.length;
            int m = grid1[0].length;
            int[][] vis = new int[n][m];
            int count = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    status = true;
                    if(grid2[i][j]==1 && vis[i][j]==0){
                        dfs(i,j,grid1,grid2,vis);
                        if(status){
                            count ++;
                        }
                    }
                }
            }
            return count;
        }
    }