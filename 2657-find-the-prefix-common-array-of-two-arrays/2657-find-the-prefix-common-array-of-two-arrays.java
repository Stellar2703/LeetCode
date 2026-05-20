class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int [] ans = new int[n];
        int []  freq = new int[n];
        int count =0;
        for(int i=0;i<n;i++){
            freq[A[i]-1]++;
            if(freq[A[i]-1]==2) count++;
            freq[B[i]-1]++;
            if(freq[B[i]-1]==2) count++;
            ans[i] = count;
        }
        return ans;
    }
}



// class Solution {
//     public int[] findThePrefixCommonArray(int[] A, int[] B) {
//         int n = A.length;
//         int [] ans = new int[n];
//         for(int i=0;i<n;i++){
//             int count =0;
//             HashSet<Integer> temp = new HashSet<>();
//             for(int j=0;j<=i;j++){
//                 temp.add(A[j]);
//             }
//             for(int j=0;j<=i;j++){
//                 if(temp.contains(B[j])){
//                     count++;
//                 }
//             }
//             ans[i] = count;
//         }
//         return ans;
//     }
// }