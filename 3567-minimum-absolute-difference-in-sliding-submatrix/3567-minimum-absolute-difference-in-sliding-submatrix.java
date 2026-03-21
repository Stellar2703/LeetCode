class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n-k+1][m-k+1];
        int x = n-k+1;
        int y = m-k+1;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){

                if (k == 1) {
                    ans[i][j] = 0;
                    continue;
                }

                int[] temp = new int[k*k];
                int index = 0;
                for(int l = i;l<i+k;l++){
                    for(int o = j;o<j+k;o++){
                        temp[index++] = grid[l][o];
                    }
                }

                Arrays.sort(temp);
                int minDiff= Integer.MAX_VALUE;
                for(int z = 1;z<temp.length;z++){
                     if (temp[z] == temp[z - 1]) continue;
                    minDiff = Math.min(minDiff,Math.abs(temp[z]-temp[z-1]));
                }
                if (minDiff == Integer.MAX_VALUE) {
    ans[i][j] = 0;
} else {
    ans[i][j] = minDiff;
}
            }
        }
        return ans;
    }
}