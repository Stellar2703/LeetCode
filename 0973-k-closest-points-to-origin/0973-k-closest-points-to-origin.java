class Solution {
    class Pair{
        int index;
        double dist;
        Pair(int index,double dist){
            this.index = index;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(a.dist, b.dist));
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            double q = Math.sqrt((x*x)+(y*y));
            pq.offer(new Pair(i,q));
        }
        int [][] ans =new int[k][2];
        for(int i =0;i<k;i++){
            if(!pq.isEmpty()){
                ans[i] = points[pq.peek().index];
                pq.poll();
            }
        }
        return ans;
    }
}