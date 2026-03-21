class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int end_row = x+k-1;
        while(x<end_row){
            for(int i =0;i<k;i++){
                int temp = grid[x][y+i];
                grid[x][y+i] = grid[end_row][y+i];
                grid[end_row][y+i] = temp;
                // System.out.println(x+" "+(y+i)+"  "+end_row+" "+(y+i));
            }
            x++;
            end_row--;
        }
        return grid;
    }
}