class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 0;

        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.putIfAbsent(arr[i], new ArrayList<>());
            mp.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int step = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int node = q.poll();

                if (node == n - 1)
                    return step;

                // left
                if (node - 1 >= 0 && !vis[node - 1]) {
                    vis[node - 1] = true;
                    q.offer(node - 1);
                }

                // right
                if (node + 1 < n && !vis[node + 1]) {
                    vis[node + 1] = true;
                    q.offer(node + 1);
                }

                // same value
                for (int nei : mp.get(arr[node])) {

                    if (!vis[nei]) {
                        vis[nei] = true;
                        q.offer(nei);
                    }
                }

                // optimization
                mp.get(arr[node]).clear();
            }

            // IMPORTANT:
            // increase after one whole BFS level
            step++;
        }

        return -1;
    }
}

// class Solution {
//     private int bfs (ArrayList<ArrayList<Integer>> adj){
//         Queue<Integer> q =new LinkedList<>();
//         q.offer(0);
//         boolean[] vis = new boolean[adj.size()];
//         vis[0] = true;
//         int count =0;
//         while(!q.isEmpty()){
//             int size =q.size();
//             for(int i=0;i<size;i++){
//                 int node = q.poll();
//                 if(node == adj.size()-1) return count;
//                 for(int edge : adj.get(node)){
//                     if(!vis[edge]){
//                     vis[edge] = true;   
//                     q.offer(edge);
//                     }
//                 }
//             }
//             count++;
//         }
//         return 0;
//     }
//     public int minJumps(int[] arr) {
//         HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
//         for (int i = 0; i < arr.length; i++) {
//             mp.putIfAbsent(arr[i], new ArrayList<>());
//             mp.get(arr[i]).add(i);
//         }
//         ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
//         for(int i =0;i<arr.length;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<arr.length;i++){
//             if(i>0){
//                 adj.get(i).add(i-1);
//             }
//             if(i<arr.length-1){
//                 adj.get(i).add(i+1);
//             }
//             for(int j :mp.get(arr[i])){
//                 if(j!=i) adj.get(i).add(j);
//             }
//         }
//         return bfs(adj);
//     }
// }

// class Solution {

//     private int f(int index, int[] arr,
//                   HashMap<Integer, ArrayList<Integer>> mp,
//                   boolean[] vis) {

//         if (index == arr.length - 1)
//             return 0;

//         if (index < 0 || index >= arr.length)
//             return 100000;

//         if (vis[index])
//             return 100000;

//         vis[index] = true;

//         int ans = 100000;

//         ans = Math.min(ans,
//                 1 + f(index + 1, arr, mp, vis));

//         ans = Math.min(ans,
//                 1 + f(index - 1, arr, mp, vis));

//         for (int i : mp.get(arr[index])) {
//             if (i != index) {
//                 ans = Math.min(ans,
//                         1 + f(i, arr, mp, vis));
//             }
//         }

//         vis[index] = false;

//         return ans;
//     }

//     public int minJumps(int[] arr) {

//         HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();

//         for (int i = 0; i < arr.length; i++) {
//             mp.putIfAbsent(arr[i], new ArrayList<>());
//             mp.get(arr[i]).add(i);
//         }

//         boolean[] vis = new boolean[arr.length];

//         return f(0, arr, mp, vis);
//     }
// }