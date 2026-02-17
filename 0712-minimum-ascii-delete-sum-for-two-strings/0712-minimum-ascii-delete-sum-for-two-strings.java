class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev =new int[m+1];
        for(int i=1;i<=m;i++){
            prev[i] = prev[i-1]+s2.charAt(i-1);
        }
        for(int i=1;i<=n;i++){
            int [] curr = new int[m+1];
            curr[0] = prev[0]+s1.charAt(i-1);
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) curr[j] = prev[j-1];
                else{
                    curr[j] = Math.min(s1.charAt(i-1)+prev[j],s2.charAt(j-1)+curr[j-1]);
                }
            }
            prev  = curr;
        }
        return prev[m];
    }
}


// class Solution {
//     public int minimumDeleteSum(String s1, String s2) {
//         int n = s1.length();
//         int m = s2.length();
//         int[][] prev = new int [n+1][m+1];
//         int sum =0;
//         for(int i=1;i<=n;i++){
//             sum +=(int)s1.charAt(i-1);
//             prev[i][0]=sum;
//         }
//         sum=0;
//         for(int i=1;i<=m;i++){
//             sum+=(int) s2.charAt(i-1);
//             prev[0][i] = sum;
//         }
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=m;j++){
//                 if(s1.charAt(i-1)==s2.charAt(j-1)) prev[i][j] = prev[i-1][j-1];
//                 else{
//                     prev[i][j] = Math.min(s1.charAt(i-1)+prev[i-1][j],s2.charAt(j-1)+prev[i][j-1]);
//                 }
//             }
//         }
//         return prev[n][m];
//     }
// }



// class Solution {
//     int f(String s1,String s2,int i, int j,int[][] prev){
//         if(i<0){
//             int sum =0;
//             for(int x = j;x>=0;x--){
//                 sum = sum + s2.charAt(x);
//             }
//             return sum;
//         }
//         if(j<0) {
//             int sum =0;
//             for(int x = i;x>=0;x--){
//                 sum = sum + s1.charAt(x);
//             }
//             return sum;
//         }
//         if(prev[i][j]!=-1) return prev[i][j];
//         if(s1.charAt(i)==s2.charAt(j)) return f(s1,s2,i-1,j-1,prev);

//         return prev[i][j] = Math.min((int) s1.charAt(i) + f(s1,s2,i-1,j,prev),
//                         (int) s2.charAt(j) + f(s1,s2,i,j-1,prev));
//     }
//     public int minimumDeleteSum(String s1, String s2) {
//         int[][] prev =new int[s1.length()][s2.length()];
//         for(int i=0;i<s1.length();i++){
//             Arrays.fill(prev[i],-1);
//         }
//         return f(s1,s2,s1.length()-1,s2.length()-1,prev);
//     }
// }