class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int [] ans = new int[n];
        for(int i=0;i<n;i++){
            int count =0;
            HashSet<Integer> temp = new HashSet<>();
            for(int j=0;j<=i;j++){
                temp.add(A[j]);
            }
            for(int j=0;j<=i;j++){
                if(temp.contains(B[j])){
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}