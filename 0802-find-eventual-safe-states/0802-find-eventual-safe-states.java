class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        int[] outdeg = new int[graph.length];
        int index = 0;
        for(int[] edge : graph){
            for(int a : edge){
                adj.get(a).add(index);
                outdeg[index]++;
            }
            index++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<graph.length;i++){
            if (outdeg[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int a  : adj.get(node)){
                outdeg[a]--;
                if(outdeg[a]==0){
                    q.offer(a);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}