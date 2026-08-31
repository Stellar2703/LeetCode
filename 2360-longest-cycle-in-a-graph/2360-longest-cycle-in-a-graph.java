class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int [] vis = new int[n];
        int [] dist = new int[n];
        int depth = 0,max = -1,id = 1;
        for(int i =0;i<n;i++){
            if(vis[i]==1) continue;
            depth++;
            int node = i;
            id++;
            while(edges[node]!=-1 && vis[node]==0){
                dist[node] = depth;
                vis[node] = id;
                node = edges[node];
                depth++;
            }
            if(vis[node]==id){
                max = Math.max(depth-dist[node],max);
            }
        }
        return max;
    }
}


// class Solution {
//     List<List<Integer>> adj;
//     HashSet<Integer> path;
//     HashMap<Integer,Integer> mp = new HashMap<>();
//     int [] vis ;
//     int max = -1;
//     public void dfs(int node,int rev){
//         vis[node] = 1;
//         path.add(node);
//         mp.put(node,rev);
//         for(int i : adj.get(node)){
//             if(vis[i]!=1)
//             dfs(i,rev+1);
//             else{ 
//                 if (path.contains(i)){
//                 int num = rev+1-mp.get(i);
//                 max = Math.max(num,max);
//             }
//             }
//         }
//     }
//     public int longestCycle(int[] edges) {
//         int n = edges.length;
//         adj = new ArrayList<>();
//         path = new HashSet<>();
//         for(int i=0;i<n;i++) adj.add(new ArrayList<>());
//         vis = new int[n];
//         for(int i=0;i<n;i++){
//             if(edges[i]!=-1)
//             adj.get(i).add(edges[i]);
//         }
//         for(int i =0;i<n;i++){
//             if(vis[i]!=1){  
//                 path.clear();
//                 dfs(i,1);
//             }
//         }
//         return max>1 ? max : -1;
//     }
// }