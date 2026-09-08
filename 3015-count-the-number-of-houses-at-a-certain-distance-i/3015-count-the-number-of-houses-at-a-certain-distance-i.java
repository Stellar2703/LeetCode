class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] matrix = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = (int)1e9;
                }
            }
        }

        for(int i =1;i<n;i++){
            matrix[i][i+1]=1;
            matrix[i+1][i] =1;
        }
        matrix[x][y] =1;
        matrix[y][x]=1;

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }

        int[] ans = new int[n];
        for(int i =1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j){
                    ans[matrix[i][j]-1]++;
                }
            }
        }

        return ans;
    }
}