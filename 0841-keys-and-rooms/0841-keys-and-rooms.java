class Solution {
    public void dfs(int index,List<List<Integer>> rooms,int[] vis){
        vis[index]  = 1;
        for(int a : rooms.get(index)){
            if(vis[a]==0) dfs(a,rooms,vis);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int [] vis = new int[rooms.size()];
        dfs(0,rooms,vis);
        for(int i=0;i<rooms.size();i++){
            if(vis[i]==0) return false;
        }
        return true;
    }
}



// BFS Approach

// class Solution {
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         int [] vis = new int[rooms.size()];
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(0);
//         int count = 1;
//         vis[0] =1;
//         while(!q.isEmpty()){
//             int node = q.poll();
//             for(int a : rooms.get(node)){
//                 if(vis[a]==0){
//                     vis[a]=1;
//                     count++;
//                     q.offer(a);
//                 }
//             }
//         }
//         return count == rooms.size();
//     }
// }