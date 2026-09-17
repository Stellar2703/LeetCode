class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int [] edge : paths){
            int u = edge[0];
            int v = edge[1];
            adj.get(u-1).add(v-1);
            adj.get(v-1).add(u-1);
        }

          for(int node = 0 ;node<n;node++){
            boolean[] used = new boolean[5];

            for(int edge : adj.get(node)){
                if(ans[edge]!=0){
                    used[ans[edge]] = true;
                }
            }
            for(int flower = 1;flower<=4;flower++){
                if(used[flower]==false){
                    ans[node] = flower;
                    break;
                }
            }
        }
        return ans;
    }
}


// class Solution {
//     public int[] gardenNoAdj(int n, int[][] paths) {
//         int[] ans = new int[n];
//         List<HashSet<Integer>> choice = new ArrayList<>();
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i =0;i<n;i++){
//             choice.add(new HashSet<>());
//             adj.add(new ArrayList<>());
//         }
//         int []  avail = {1,2,3,4};
//         for(int [] edge : paths){
//             int u = edge[0];
//             int v = edge[1];
//             adj.get(u-1).add(v-1);
//             adj.get(v-1).add(u-1);
//         }

//         for(int node = 0 ;node<n;node++){
//             for(int flower = 1;flower<=4;flower++){
//                 if(!choice.get(node).contains(flower)){
//                     ans[node] = flower;
//                     for(int edge : adj.get(node)){
//                         choice.get(edge).add(flower);
//                     }
//                     break;
//                 }
//             }
//         }
//         return ans;

        
        
//     }
// }

