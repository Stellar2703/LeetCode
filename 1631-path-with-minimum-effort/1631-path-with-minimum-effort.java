class Solution {
    class Pair{
        int dist,row,col;
        Pair(int dist,int row,int col){
            this.dist = dist;
            this.row = row;
            this.col= col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
    PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);
    int n = heights.length;
    int m = heights[0].length;
    int[][] dist = new int[n][m];
    for(int i = 0; i < n; i++){
    Arrays.fill(dist[i], Integer.MAX_VALUE);
}
    dist[0][0] = 0;
    q.offer(new Pair(0,0,0));
    int[] drow = {0,1,0,-1};
    int[] dcol = {-1,0,1,0};
    while(!q.isEmpty()){
        int row =  q.peek().row;
        int col = q.peek().col;
        int curr_dist = q.peek().dist;
        q.poll();
        if(dist[row][col]<curr_dist)continue;
        if(row==n-1 && col==m-1){
            return curr_dist;
        }
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m ){
                int temp_dist = Math.abs(heights[row][col] - heights[nrow][ncol]);
                int newEffort = Math.max(curr_dist, temp_dist);
                System.out.println(row+" "+col);
                if(newEffort<dist[nrow][ncol]){
                dist[nrow][ncol] = newEffort;                    
                q.offer(new Pair(newEffort,nrow,ncol));
                }
            }
        }
    }
    return 0;
    }
}