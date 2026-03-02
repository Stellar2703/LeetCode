class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e8);
        dist[src] = 0;
        for(int i=0;i<k+1;i++){
            int [] temp = dist.clone();
            for(int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if(dist[u]!=1e8 && dist[u]+w<temp[v]){
                    temp[v] = dist[u]+w;
                }
            }
            dist = temp;
        }
        if(dist[dst]!=1e8) return dist[dst];
        else return -1;
    }
}