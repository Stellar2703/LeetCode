class Solution {
    class Pair{
        int wt;
        int node;
        Pair(int wt,int node){
            this.wt=wt;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.wt-b.wt);
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(w,v));
        }
        int []dist = new int [n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k] = 0;
        q.offer(new Pair(0,k));
        while(!q.isEmpty()){
            int wt = q.peek().wt;
            int node = q.peek().node;
            q.poll();
            if(wt>dist[node])continue;
            for(Pair edge : adj.get(node)){
                if(wt+edge.wt < dist[edge.node]){
                    dist[edge.node] = wt+edge.wt;
                    q.offer(new Pair(dist[edge.node],edge.node));
                }
            }
        }
        int max = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == (int)1e9) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}