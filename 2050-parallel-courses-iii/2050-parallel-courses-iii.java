class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Queue<Integer> q = new LinkedList<>();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[n+1];

        for(int[] edge : relations){
            adj.get(edge[0]).add(edge[1]);
            indeg[edge[1]]++;
        }

        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            dp[i] = time[i-1];
            if(indeg[i]==0) q.offer(i);
        }

        int ans = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            ans = Math.max(ans, dp[node]);

            for(int next : adj.get(node)){
                
                dp[next] = Math.max(dp[next], dp[node] + time[next-1]);

                indeg[next]--;

                if(indeg[next]==0){
                    q.offer(next);
                }
            }
        }

        return ans;
    }
}