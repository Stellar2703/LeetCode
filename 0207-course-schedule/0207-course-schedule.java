class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int [] indeg = new int[numCourses];
        for(int [] edge : prerequisites){
            int a = edge[0];
            int b = edge[1];
            adj.get(b).add(a);
            indeg[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            if (indeg[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int a : adj.get(node)){
                indeg[a]--;
                if(indeg[a]==0){
                    q.offer(a);
                }
            }
        }
            return ans.size() == numCourses ? true : false;
        }
    }
