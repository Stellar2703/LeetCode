class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0,min=Integer.MAX_VALUE,count=0;
        for(int i =0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                min = Math.min(Math.abs(matrix[i][j]),min);
                if(matrix[i][j]<0) count++;
                sum+=Math.abs(matrix[i][j]);
            }
        }
        if(count%2==0) return sum;
        else return sum-(2*min);
    }
}