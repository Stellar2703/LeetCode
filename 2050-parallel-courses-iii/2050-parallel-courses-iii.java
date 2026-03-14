class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[n+1];
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<relations.length;i++){
            adj.get(relations[i][0]).add(relations[i][1]);
            indeg[relations[i][1]]++;
        }
        int [] dp =  new int[n+1];
        for(int i =1;i<n+1;i++){
            if(indeg[i]==0) q.offer(i);
            dp[i] = time[i-1];
        }
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
                int node = q.poll();
                ans = Math.max(ans,dp[node]);
                for(int j : adj.get(node)){
                    indeg[j]--;
                    dp[j] = Math.max(dp[j],dp[node]+time[j-1]);
                    if(indeg[j]==0) q.offer(j);
                }
        }
        return ans;
    }
}