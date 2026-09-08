class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int[] countOfPairs(int n, int x, int y) {
        List<List<Pair>> adj = new ArrayList<>();
        int[] ans = new int[n];
        for(int i =0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i =1;i<n;i++){
            adj.get(i).add(new Pair(i+1,1));
            adj.get(i+1).add(new Pair(i,1));
        }
        adj.get(x).add(new Pair(y,1));
        adj.get(y).add(new Pair(x,1));

        for(int source =1;source<=n;source++){
            int[] dist = new int[n+1];
            Arrays.fill(dist,(int)1e9);
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.dist,b.dist));
            pq.offer(new Pair(source,0));
            dist[source] = 0;
            while(!pq.isEmpty()){
                Pair p = pq.poll();

                for(Pair edge : adj.get(p.node)){
                    if(edge.dist + p.dist<dist[edge.node]){
                        dist[edge.node] = edge.dist+p.dist;
                        pq.offer(new Pair(edge.node,dist[edge.node]));
                    }
                }
            }
            for(int i =1;i<=n;i++){
                if(dist[i]!=(int)1e9 && dist[i]!=0){
                    ans[dist[i]-1]++;
                }
            }

        }
        return ans;
    }
}




// class Solution {
//     public int[] countOfPairs(int n, int x, int y) {
//         int[][] matrix = new int[n+1][n+1];

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (i == j) {
//                     matrix[i][j] = 0;
//                 } else {
//                     matrix[i][j] = (int)1e9;
//                 }
//             }
//         }

//         for(int i =1;i<n;i++){
//             matrix[i][i+1]=1;
//             matrix[i+1][i] =1;
//         }
//         matrix[x][y] =1;
//         matrix[y][x]=1;

//         for(int k=1;k<=n;k++){
//             for(int i=1;i<=n;i++){
//                 for(int j=1;j<=n;j++){
//                     matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
//                 }
//             }
//         }

//         int[] ans = new int[n];
//         for(int i =1;i<=n;i++){
//             for(int j=1;j<=n;j++){
//                 if(i!=j){
//                     ans[matrix[i][j]-1]++;
//                 }
//             }
//         }

//         return ans;
//     }
// }