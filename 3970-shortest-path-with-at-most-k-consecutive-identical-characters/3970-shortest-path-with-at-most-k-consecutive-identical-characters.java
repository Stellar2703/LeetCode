    class Solution {
        class Pair {
            int edge;
            int wt;
            int size;

            Pair(int edge, int wt, int size) {
                this.edge = edge;
                this.wt = wt;
                this.size = size;
            }
        }

        class Pairs {
            int edge;
            int wt;

            Pairs(int edge,int wt){
                this.edge = edge;
                this.wt = wt;
            }

        }

        public int shortestPath(int n, int[][] edges, String labels, int k) {
            ArrayList<ArrayList<Pairs>> adj = new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int [] edge:edges){
                int u  = edge[0];
                int v  = edge[1];
                int w  = edge[2];
                adj.get(u).add(new Pairs(v,w));
            }
            int[][] dist = new int[n][k+1];
            for(int i=0;i<n;i++){
                Arrays.fill(dist[i],(int)1e9);
            }
            dist[0][1] = 0;
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.wt - b.wt);
            pq.offer(new Pair(0,0,1));
            while(!pq.isEmpty()){
                Pair p = pq.poll();
                if(p.wt > dist[p.edge][p.size]) continue;
                if(p.edge == n-1){
                    return p.wt;
                }
                for(Pairs node : adj.get(p.edge)){
                        if(labels.charAt(p.edge)==labels.charAt(node.edge) && p.size+1 <=k && p.wt+node.wt<dist[node.edge][p.size+1]){
                            pq.offer(new Pair(node.edge,p.wt+node.wt,p.size+1));
                            dist[node.edge][p.size+1] = p.wt+node.wt;
                        }
                        if(labels.charAt(p.edge)!=labels.charAt(node.edge) && p.wt+node.wt<dist[node.edge][1]){
                            pq.offer(new Pair(node.edge,p.wt+node.wt,1));
                            dist[node.edge][1] = p.wt+node.wt;
                        }
                }
            }
            return -1;
        }
    }