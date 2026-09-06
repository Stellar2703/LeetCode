class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> hs = new HashSet<>();
        int moves = 0;
        Queue<String> q = new LinkedList<>();
        for (String gene : bank) {
    hs.add(gene);
}
        char[] valid = new char[] { 'A', 'C', 'G', 'T' };
        q.offer(startGene);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (node.equals(endGene))
                    return moves;
                char[] temp = node.toCharArray();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        temp[j] = valid[k];
                        if(hs.contains(new String(temp))){
                            q.offer(new String(temp));
                            hs.remove(new String(temp));
                        } 
                    }
                    temp[j] = node.charAt(j);
                }
            }
            moves++;
        }
        return -1;
    }
}