class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> hs = new HashSet<>();
        for(String s: deadends) hs.add(s);
        Queue<String> q = new LinkedList<>();
        int moves = 0;
        q.offer(new String("0000"));
        if(hs.contains("0000")) return -1;
        hs.add("0000");
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                String node = q.poll();
                if(node.equals(target)) return moves;
                char[] temp = node.toCharArray();
                for(int j =0;j<4;j++){
                    temp[j] = (char) ((temp[j] - '0' + 1) % 10 + '0');
                    if(!hs.contains(new String(temp))) {
                        q.offer(new String(temp));
                        hs.add(new String(temp));
                    }
                    temp[j] = node.charAt(j);
                    temp[j] = (char) ((temp[j] - '0' + 9) % 10 + '0');
                    if(!hs.contains(new String(temp))){
                        q.offer(new String(temp));
                        hs.add(new String(temp));
                    }
                    temp[j] = node.charAt(j);
                }
            }
            moves++;
        }
        return -1;
    }
}