class Solution {
    class Pair{
        int num;
        int count;
        Pair(int num,int count){
            this.num = num;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.count-b.count);
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
            if (pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int index =0;
        while(index<k){
            ans[index++] = pq.poll().num;
        }
        return ans;
    }
}