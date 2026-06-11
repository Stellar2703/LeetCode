    class Solution {
        static final long MOD = 1_000_000_007L;
        public int assignEdgeWeights(int[][] edges) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<=edges.length+1;i++){
                adj.add(new ArrayList<>());
            }
            boolean[] vis = new boolean[edges.length+2];
            for(int [] edge :edges){
                int u = edge[0];
                int v = edge[1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(1);
            int count =-1;
            vis[1] = true;
            while(!q.isEmpty()){
                int  size = q.size();
                for(int i =0;i<size;i++){
                    int node = q.poll();
                    for(int edge : adj.get(node)){
                        if(!vis[edge]){
                        vis[edge] = true;
                        q.offer(edge);
                        }
                    }
                }
                count++;
            }
            if (count == 0) return 0;

            return (int) modPow(2, count-1);
        }

        private long modPow(long a, long b) {

            long res = 1;

            while (b > 0) {

                if ((b & 1) == 1) {
                    res = (res * a) % MOD;
                }

                a = (a * a) % MOD;
                b >>= 1;
            }

            return res;
        }
    }