class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[numCourses];
        for(int[] edge : prerequisites){
            int v = edge[0];
            int u = edge[1];
            adj.get(u).add(v);
            indeg[v]++;
            }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if (indeg[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int a : adj.get(node) ){
                indeg[a]--;
                if(indeg[a]==0) q.offer(a);
            }
        }
        int[] result = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i] = ans.get(i);
        }
        if (ans.size() != numCourses) return new int[0];
        return result;
    }
}