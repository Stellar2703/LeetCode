class Solution {

    private String toStr(int[][] board){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        int level = 0;

        q.offer(toStr(board));
        vis.add(toStr(board));

        while(!q.isEmpty()){
            int size =  q.size();
            for(int i =0;i<size;i++){
                String s = q.poll();
                if(s.equals(target)) return level;
                StringBuilder sb = new StringBuilder(s);
                int row = 0,col =0,index  =0;
                for(int j =0;j<6;j++){
                    if(sb.charAt(j)=='0') {
                        index = j;
                        break;
                    }
                }
                row = index / 3;
                col = index % 3;

                int[] drow = {0, 1, 0, -1};
                int[] dcol = {-1, 0, 1, 0};

                for(int j=0;j<4;j++){
                    int nrow = row+drow[j];
                    int ncol = col+dcol[j];
                    
                    if(nrow>=0 && ncol>=0 && nrow<2 && ncol<3){
                        int nextIndex = nrow * 3 + ncol;
                        char tile = sb.charAt(nextIndex);

                        sb.setCharAt(index, tile);
                        sb.setCharAt(nextIndex, '0');
                        if(!vis.contains(sb.toString())){
                            q.offer(sb.toString());
                            vis.add(sb.toString());
                        }
                        sb.setCharAt(index, '0');
                        sb.setCharAt(nextIndex, tile);
                    }
                }
                
            }
            level++;
        }
        return -1;
    }
}