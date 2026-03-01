class Solution {
    class Pair{
        int node;
        double prob;
        Pair(double prob,int node){
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->Double.compare(b.prob, a.prob));
        int index = 0;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            double w = succProb[index++];
            adj.get(u).add(new Pair(w,v));
            adj.get(v).add(new Pair(w,u));
        }
        double[] dist = new double[n];
        Arrays.fill(dist,0);
        q.offer(new Pair(1,start_node));
        dist[start_node] = 1;
        while(!q.isEmpty()){
            int node = q.peek().node;
            double prob = q.peek().prob;
            q.poll();
            if(node == end_node){
                return prob;
            }
            if(prob < dist[node]) continue;
            for(Pair a : adj.get(node)){
                int new_node = a.node;
                double new_prob = a.prob;
                if(dist[new_node]<(new_prob*prob)){
                    dist[new_node] = (new_prob*prob);
                    q.offer(new Pair(new_prob*prob,new_node));
                }
            }
        }
        return (double)0;
    }
}