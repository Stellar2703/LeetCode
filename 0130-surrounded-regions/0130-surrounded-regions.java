class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int [n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                q.offer(new Pair(i,0));
                vis[i][0] = 1;
            }
            if(board[i][m-1]=='O'){
                q.offer(new Pair(i,m-1));
                vis[i][m-1] = 1 ;
            }
        }
        for(int j = 0;j<m;j++){
            if(board[0][j] == 'O'){
                q.offer(new Pair(0,j));
                vis[0][j] =1 ;
            }
            if(board[n-1][j]=='O'){
                q.offer(new Pair(n-1,j));
                vis[n-1][j] = 1;
            }
        }
        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            for(int i=0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && board[nrow][ncol]=='O' && vis[nrow][ncol]!=1){
                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }
}