class Solution {
    public long removeZeros(long n) {
        long multi = 1;
        long ans=0;
        while(n>0){
            int temp = (int)(n%10);
            if(temp!=0){
            ans = temp*multi + ans;
            multi*=10;
            }
            n/=10;
        }
        return ans;
    }
}