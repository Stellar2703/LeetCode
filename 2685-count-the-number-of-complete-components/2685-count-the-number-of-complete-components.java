class Solution {
    List<List<Integer>> adj;
    int[] vis;
    int v = 0,e = 0;
    private void dfs(int node){
        vis[node] = 1;
        v+=1;
        e+=adj.get(node).size();
        for(int vertex : adj.get(node)){
            if(vis[vertex]==0){
                dfs(vertex);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        vis = new int[n];
        adj = new ArrayList<>();
        int ans =0;

        for(int i =0;i<n;i++)adj.add(new ArrayList<>());

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        for(int i =0;i<n;i++){
            if(vis[i]==0){
                v = 0;
                e = 0;
                dfs(i);

                int edge = e/2;
                int vertices = (v*(v-1))/2;

                if(edge == vertices) ans++;
            }
        }

        return ans;
    }
}




    // class Solution {
    //     List<List<Integer>> adj;
    //     int [] vis;
    //     int times = 1,ans=0;
    //     public int dfs(int node){
    //         int res = 1;
    //         vis[node] = times;
    //         for(int edge : adj.get(node)){
    //             if(vis[edge]==0){
    //                 res += dfs(edge);
    //             }
    //         }
    //         return res;

    //     }
    //     public int countCompleteComponents(int n, int[][] edges) {
    //         int[] count = new int[n];
    //         vis = new int[n];
    //         adj =new ArrayList<>();
    //         Boolean isTrue = true;
    //         for(int i=0;i<n;i++)adj.add(new ArrayList<>());
    //         for(int [] edge :edges){
    //             int u = edge[0];
    //             int v = edge[1];
    //             adj.get(u).add(v);
    //             adj.get(v).add(u);
    //             count[u]++;
    //             count[v]++;
    //         }

    //         for(int i =0;i<n;i++){
    //             if(vis[i]==0){
    //                 int node = dfs(i);
                
    //             isTrue = true;
    //             for(int j =0;j<n;j++){
    //                 if(vis[j]==times && node-1 != count[j]){
    //                     isTrue = false;
    //                 }
    //             }
    //             if(isTrue)ans++;
    //             times++;
    //             }
    //         }
            
    //         return ans;
    //     }
    // }