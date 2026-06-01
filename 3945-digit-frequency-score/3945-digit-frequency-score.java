class Solution {
    public int digitFrequencyScore(int n) {
        int[] arr = new int[10];
        while(n>0){
            int temp = n%10;
            arr[temp]++;
            n=n/10;
        }
        int ans =0;
        for(int i=0;i<=9;i++){
            ans+= (i*arr[i]);
        }
        return ans;
    }
}