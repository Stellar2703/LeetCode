class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            indeg[u]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }

        int count =0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int a: adj.get(node)){
                indeg[a]--;
                if(indeg[a]==0){
                    q.offer(a);
                }
            }
        }
        return count == n ? true : false;
    }
}