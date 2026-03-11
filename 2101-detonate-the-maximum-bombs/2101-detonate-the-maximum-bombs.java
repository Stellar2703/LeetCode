class Solution {
    public int dfs(int i,List<List<Integer>> adj,int[] vis,int[] count){
        vis[i] = 1;
        count[0] ++;
        for(int j : adj.get(i)){
            if(vis[j]!=1) dfs(j,adj,vis,count);
        }
        return count[0];
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long dist = dx * dx + dy * dy;

                long r = bombs[i][2];

                if (dist <= r * r) {
                    adj.get(i).add(j);
                }
            }
        }
        int max = 0;
        for(int i =0;i<n;i++){
            int [] vis = new int[n];
            int[] count = new int[1];
            max = Math.max(max,dfs(i,adj,vis,count));
        }
        return max;
    }
}