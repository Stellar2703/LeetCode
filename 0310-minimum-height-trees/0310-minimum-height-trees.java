class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        return res;
        }
        
        if (n == 2) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        return res;
        } // summa to check my intuition

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int [] indeg = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge :edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            indeg[u]++;
            indeg[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==1) q.offer(i);
        }
        int count = 0;
        while(count < n-2){
            int size  = q.size();
            
            for(int i=0;i<size;i++){
                int node = q.poll();
                count ++;
                for(int a : adj.get(node)){
                    indeg[a]--;
                    if(indeg[a]==1){
                        q.offer(a);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }
}