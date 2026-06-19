class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col = col;
        }
    }
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int[][] vis =new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1 && vis[i][j]!=1){
                    ArrayList<Integer> temp =new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    q.offer(new Pair(i,j));
                    int frow=0;
                    int fcol=0;
                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        if(p.row>=0 && p.col>=0 && p.row<n && p.col<m && land[p.row][p.col]==1 && vis[p.row][p.col]!=1){
                            q.offer(new Pair(p.row+1,p.col));
                            q.offer(new Pair(p.row-1,p.col));
                            q.offer(new Pair(p.row,p.col+1));
                            q.offer(new Pair(p.row,p.col-1));
                            vis[p.row][p.col]=1;
                            frow = p.row;
                            fcol = p.col;
                        }
                    }
                    temp.add(frow);
                    temp.add(fcol);
                    ans.add(new ArrayList<>(temp));
                }
            }
        }
        int[][] res = new int[ans.size()][4];
        for(int i =0;i<ans.size();i++){
            for(int j=0;j<4;j++){
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }
}