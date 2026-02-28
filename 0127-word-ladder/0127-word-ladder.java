class Solution {
    class Pair{
        String s;
        int step;
        Pair(String s , int step){
            this.s  = s;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> mp  =new HashSet<>();
        for(String s : wordList){
            mp.add(s);
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.s;
            int step = p.step;
            if(s.equals(endWord)) return step;
            mp.remove(s);
            for(int i=0;i<s.length();i++){
                for(int j=0;j<26;j++){
                    char [] temp =  s.toCharArray();
                    temp[i] = (char)('a'+j);
                    String comp = new String(temp);
                    if(mp.contains(comp)){
                        q.offer(new Pair(comp,step+1));
                        mp.remove(comp);
                    }
                }
            }
        }
    return 0;
    }
}