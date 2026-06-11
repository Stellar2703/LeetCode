class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int gift : gifts){
            pq.add(gift);
        }
        while(k>0){
            int temp = pq.poll();
            temp = (int)Math.floor(temp/Math.sqrt(temp));
            pq.add(temp);
            k--;
        }
        long ans = 0;
        while(!pq.isEmpty()){
            ans+=pq.poll();
        }
        return ans;
    }
}