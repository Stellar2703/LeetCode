class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int small = Integer.MAX_VALUE;
        int neg= 0;
        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                small = Math.min(small,Math.abs(matrix[i][j]));
                if(matrix[i][j]<0)neg++;
                sum+=Math.abs(matrix[i][j]);
            }
        }
        if(neg%2==0)return sum;
        return sum-(2*small);
    }
}