class Solution {
    class Pair{
        long wt;
        int node;
        Pair(long wt,int node){
            this.wt = wt;
            this.node = node;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)-> Long.compare(a.wt, b.wt));
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adj.get(u).add(new Pair(w,v));
            adj.get(v).add(new Pair(w,u));
        }
        long[] dist = new long[n];
        int[] ways = new int[n];
        int MOD = (int)(1e9 + 7);
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        q.offer(new Pair(0,0));
        while(!q.isEmpty()){
            int node = q.peek().node;
            long wt = q.peek().wt;
            q.poll();
            if(wt>dist[node]) continue;
            for(Pair p : adj.get(node)){
                int n_node = p.node;
                long n_wt = p.wt;
                if(wt+n_wt<dist[n_node]){
                    dist[n_node] = wt+n_wt;
                    ways[n_node] = ways[node];
                    q.offer(new Pair(dist[n_node],n_node));
                }
                else if(wt+n_wt==dist[n_node]){
                    ways[n_node] = (ways[node]+ways[n_node]) % MOD;
                }
            }
        }
        return ways[n-1];
    }
}