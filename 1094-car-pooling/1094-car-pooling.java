class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Arrays.sort(trips,(a,b)->{
        //     if(a[1]!=b[1]){
        //         return Integer.compare(a[1],b[1]);
        //     }
        //     return Integer.compare(a[2],b[2]);
        // });
        // int cap = 0;
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        // for(int i =0;i<trips.length;i++){
        //     while(!pq.isEmpty() && pq.peek()[0]<=trips[i][1]){
        //         // System.out.println("hi");
        //         cap-=pq.peek()[1];
        //         pq.poll();
        //     }
        //     // System.out.println(cap);
        //     cap+=trips[i][0];
        //     pq.offer(new int[]{trips[i][2],trips[i][0]});
        //     if(cap>capacity) return false;
        // }
        // return true;

        int n = trips.length;
        ArrayList<int[]> arr = new ArrayList<>();
        for(int[] trip:trips){
            arr.add(new int[]{trip[1],trip[0]});
            arr.add(new int[]{trip[2],-trip[0]});
        }
        Collections.sort(arr,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        int cap =0;
        for(int[] trip :arr){
            System.out.println(trip[0]);
            cap+=trip[1];
            if(cap>capacity)return false;
        }
        return true;
    }
}