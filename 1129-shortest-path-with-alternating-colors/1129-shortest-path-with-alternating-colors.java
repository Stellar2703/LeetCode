class Solution {
    class Pair{
        int node;
        int color;
        Pair(int node,int color){
            this.node = node;
            this.color = color;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Pair>> adj = new ArrayList<>();
        int[] dist = new int[n];
        int[][] vis = new int[n][2];
        
        Arrays.fill(dist,(int)1e9);

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int [] edge : redEdges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new Pair(v,1));
        }

        for(int [] edge : blueEdges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new Pair(v,2));
        }

        Queue<Pair> q = new LinkedList<>();
        dist[0] = 0;
        vis[0][1] = 1;
        vis[0][0] = 1;
        int level = 2;

        for(Pair edge : adj.get(0)){
            dist[edge.node] = Math.min(dist[edge.node], 1);
            vis[edge.node][edge.color-1]=1;
            q.offer(edge);
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i =0;i<size;i++){
                Pair node = q.poll();
                for(Pair edge : adj.get(node.node)){
                    if(edge.color!= node.color && vis[edge.node][edge.color-1]==0){
                        vis[edge.node][edge.color-1]=1;
                        q.offer(edge);
                        dist[edge.node] = Math.min(dist[edge.node],level);
                    }
                }

            }
            level++;
        }
        for(int i =0;i<n;i++){
            if(dist[i]==(int)1e9){
                dist[i]=-1;
            }
        }

        return dist;
    }
}