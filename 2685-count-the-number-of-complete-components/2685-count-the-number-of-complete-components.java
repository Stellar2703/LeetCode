    class Solution {
        List<List<Integer>> adj;
        int [] vis;
        int times = 1,ans=0;
        public int dfs(int node){
            int res = 1;
            vis[node] = times;
            for(int edge : adj.get(node)){
                if(vis[edge]==0){
                    res += dfs(edge);
                }
            }
            return res;

        }
        public int countCompleteComponents(int n, int[][] edges) {
            int[] count = new int[n];
            vis = new int[n];
            adj =new ArrayList<>();
            Boolean isTrue = true;
            for(int i=0;i<n;i++)adj.add(new ArrayList<>());
            for(int [] edge :edges){
                int u = edge[0];
                int v = edge[1];
                adj.get(u).add(v);
                adj.get(v).add(u);
                count[u]++;
                count[v]++;
            }

            for(int i =0;i<n;i++){
                if(vis[i]==0){
                    int node = dfs(i);
                
                isTrue = true;
                for(int j =0;j<n;j++){
                    if(vis[j]==times && node-1 != count[j]){
                        isTrue = false;
                    }
                }
                if(isTrue)ans++;
                times++;
                }
            }
            
            return ans;
        }
    }