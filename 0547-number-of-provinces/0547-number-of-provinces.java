class Solution {

    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[node] = 1;
        for(int a: adj.get(node)){
            if(vis[a]==0){
                dfs(a,adj,vis);
        }
        }    
    }
    public int findCircleNum(int[][] isConnected) {
        // convert  to adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;

        for(int i=0;i<n;i++) adj .add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        // coount the number of the dfs calls done by the user;
        int[] vis = new int[n];
        int count =0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                count ++;
                dfs(i,adj,vis);
            }
        }
        return count;
    }
}