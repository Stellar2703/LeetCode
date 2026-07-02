class Solution {
    public int islandPerimeter(int[][] grid) {
        int row= grid.length;
        int col = grid[0].length;
        int count =0;
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    if((i-1>=0 &&grid[i-1][j]!=1) ||i==0) count++;
                    if((i+1<row &&grid[i+1][j]!=1) || i==row-1) count++;
                    if((j-1>=0 &&grid[i][j-1]!=1) ||j==0 ) count++;
                    if((j+1<col &&grid[i][j+1]!=1) || j==col-1) count++;

                }
            }
        }
        return count;
    }
}