class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int [] vis = new int[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int count = 1;
        vis[0] =1;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int a : rooms.get(node)){
                if(vis[a]==0){
                    vis[a]=1;
                    count++;
                    q.offer(a);
                }
            }
        }
        return count == rooms.size();
    }
}