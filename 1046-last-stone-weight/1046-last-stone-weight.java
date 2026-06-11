class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int p1 = pq.poll();
            int p2 = pq.poll();
            if(p1!=p2){
                pq.offer(p1-p2);
            }
        }
        return pq.size()== 0 ? 0 : pq.poll();
    }
}