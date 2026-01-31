class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for (int[] edge : prereq) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            indeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int a : adj.get(node)) {
                indeg[a]--;
                if (indeg[a] == 0) {
                    q.offer(a);
                }
            }
        }
        if (ans.size() != n)
            return new int[0];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}