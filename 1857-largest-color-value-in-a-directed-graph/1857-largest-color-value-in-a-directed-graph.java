class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int ans = 0;
        int n = colors.length();
        int[][] dp = new int[colors.length()+1][26];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indeg[v]++;
        }
        int[] indeg1 = new int[n];
        for(int i=0;i<n;i++){
            if (indeg[i]==0){
                 q.offer(i);
            }
        }
        
        int count =0;
        while (!q.isEmpty()){
            int node = q.poll();
            dp[node][colors.charAt(node)-'a'] ++;
            count++;
            ans = Math.max(dp[node][colors.charAt(node)-'a'],ans);
            for(int a : adj.get(node)){
                for(int i=0;i<26;i++){
                    dp[a][i] = Math.max(dp[a][i],dp[node][i]);
                }
                indeg[a]--;
                if(indeg[a]==0){
                    q.offer(a);
                }
            }
        }
        if(count<n) return -1;
        return ans;
    }
}