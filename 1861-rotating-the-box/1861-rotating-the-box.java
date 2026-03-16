class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        for(int i=0;i<n;i++){
            int r=m-1;
            for(int l=m-1;l>=0;l--){
                if(boxGrid[i][l] == '*'){
                    r = l-1;
                }

                if(boxGrid[i][l]=='#'){
                    char temp = boxGrid[i][l];
                    boxGrid[i][l] = boxGrid[i][r];
                    boxGrid[i][r] = temp;
                    r--;
                }
            }
        }
        char[][] ans = new char[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j][n-1-i] = boxGrid[i][j];
            }
        }
        return ans;
    }
}