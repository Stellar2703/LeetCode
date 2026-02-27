class Solution {
    public boolean isSafe(int row,int n,int col,char[][] board){
          for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }
        for(int i= row-1,j=col-1;i>=0 && j>=0;j--,i--){
            if(board[i][j]=='Q') return false;
        }

        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    public void f(int row,int n,int[] ans,char[][] board){
        if(row==n) {
            ans[0]+=1;
            return;
        }

        for(int col =0;col<n;col++){
            if(isSafe(row,n,col,board)){
                board[row][col]= 'Q';
                f(row+1,n,ans,board);
                board[row][col]='.';
            }
        }
    }
    public int totalNQueens(int n) {
        char [][] board = new char [n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        int[] ans = new int[1];
        f(0,n,ans,board);
        return ans[0];
    }
}