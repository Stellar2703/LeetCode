class Solution {
    int timer = 1;
    ArrayList<ArrayList<Integer>> adj;
    int [] vis;
    int[] tim;
    int[] low;
    List<List<Integer>> bridges;
    private void dfs(int node,int parent){
        vis[node] = 1;
        low[node] = timer;
        tim[node] = timer;
        timer++;
        for(int child : adj.get(node)){
        if (child == parent) continue;
        if(vis[child]==0){
            dfs(child,node);
            low[node] = Math.min(low[node],low[child]);
            if(low[child]>tim[node]){
                bridges.add(Arrays.asList(child,node));
            }
        }
        else{
            low[node] = Math.min(low[node],low[child]);
        }

        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adj = new ArrayList<>();
        for(int i =0;i<n;i++)adj.add(new ArrayList<>());
        for(List<Integer> con : connections){
            int u = con.get(0);
            int v = con.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        vis = new int[n];
        tim = new int[n];
        low = new int[n];
        bridges = new ArrayList<>();

        dfs(0,-1);

        return bridges;

    }
}