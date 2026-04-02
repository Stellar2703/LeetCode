class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x= x;
            this.y=y;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;

        Queue<Pair> q = new LinkedList<>();

        int [] drow = {0,1,0,-1};
        int [] dcol = {-1,0,1,0};
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    q.offer(new Pair(i,j));
                    count++;
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        grid[p.x][p.y] = '2';
                        
                        for(int z =0;z<4;z++){
                            int nrow = p.x + drow[z];
                            int ncol = p.y + dcol[z];

                            if(nrow>=0 && ncol>=0 && nrow<=n-1 && ncol<=m-1 && 
                            grid[nrow][ncol]=='1'){
                                q.offer(new Pair(nrow,ncol));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}



































// class Solution {
//     public void dfs(int i,int j,char[][] grid, int[][] vis){
//         int n = grid.length;
//         int m = grid[0].length;
//         vis[i][j] = 1;
//         int[] drow = {0,1,0,-1};
//         int[] dcol = {-1,0,1,0};
//         for (int p=0;p<4;p++){
//             int nrow = i + drow[p];
//             int ncol = j + dcol[p];
//             if(nrow>=0 && nrow<=n-1 && ncol>=0 && ncol<=m-1 && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
//                 dfs(nrow,ncol,grid,vis);
//             }
//         }
//     }
//     public int numIslands(char[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int [][] vis = new int [n][m];
//         int count =0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]=='1' && vis[i][j]!=1){
//                     count ++;
//                     dfs(i,j,grid,vis);
//                 }
//             }
//         }
//         return count;
//     }
// }