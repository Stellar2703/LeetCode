class Solution {
    class Pair{
        int node;
        boolean original;
        Pair(int node,boolean original){
            this.node = node;
            this.original  = original;
        }
    }
    int ans = 0;
    List<List<Pair>> adj;
    int[] vis;

    private void dfs(int node){
        vis[node] = 1;
        for(Pair edge : adj.get(node)){
            if(vis[edge.node]==0){

            
            if(edge.original == true){
                ans++;
            }
            dfs(edge.node);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        vis = new int[n];
        adj = new ArrayList<>();

        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int [] edge : connections){
            int u = edge[0];
            int v  =edge[1];

            adj.get(u).add(new Pair(v,true));
            adj.get(v).add(new Pair(u,false));

        }

        dfs(0);
        return ans;
    }
}