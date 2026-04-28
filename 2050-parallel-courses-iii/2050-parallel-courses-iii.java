class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg= new int[n+1];
        int[] dp = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int [] edge : relations){
            int u =edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indeg[v]++;
        }
        for(int i =1;i<=n;i++){
            if(indeg[i]==0) {
                q.offer(i);
                dp[i] = time[i-1];
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            for(int edge : adj.get(node)){
                indeg[edge]--;
                dp[edge] = Math.max(dp[edge],dp[node]+time[edge-1]);
                if(indeg[edge]==0){
                    q.offer(edge);
                }
            }
        }
        int ans =0;
        for(int i =1;i<=n;i++){
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}