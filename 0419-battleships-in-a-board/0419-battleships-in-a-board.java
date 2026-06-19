// class Solution {
//     class Pair{
//         int row;
//         int col;
//         Pair(int row, int col){
//             this.row=row;
//             this.col =col;
//         }
//     }
//     public int countBattleships(char[][] board) {
//         Queue<Pair> q = new LinkedList<>();
//         int n = board.length;
//         int m = board[0].length;
//         int[][] vis =new int[n][m];
//         int count =0;
//         for(int i =0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(board[i][j]=='X' && vis[i][j]!=1){
//                     q.offer(new Pair(i,j));
//                     count++;
//                     while(!q.isEmpty()){
//                         Pair p = q.poll();
//                         if(p.row>=0 && p.row<n &&p.col>=0 && p.col<m && board[p.row][p.col]=='X' && vis[p.row][p.col]!=1){
//                             vis[p.row][p.col]=1;
//                             q.offer(new Pair(p.row+1,p.col));
//                             q.offer(new Pair(p.row-1,p.col));
//                             q.offer(new Pair(p.row,p.col+1));
//                             q.offer(new Pair(p.row,p.col-1));
//                         }
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }




class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') continue;
                    if (j > 0 && board[i][j - 1] == 'X') continue;
                    count++;
                }
            }
        }

        return count;
    }
}