class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        q.offer(x);
        int ops = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                if (node == y)
                    return ops;
                if (y >= node) {
                    q.offer(node + 1);
                } else {
                    if (node % 11 == 0 && hs.add(node/11))
                        q.offer(node / 11);
                    if (node % 5 == 0 && hs.add(node/5))
                        q.offer(node / 5);
                    if(hs.add(node-1))q.offer(node - 1);
                    if(hs.add(node+1))q.offer(node + 1);
                }
            }
            ops++;
        }
        return 0;
    }
}