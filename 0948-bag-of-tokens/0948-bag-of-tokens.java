class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int l=0,r=tokens.length-1,count=0,ans=0;
        Arrays.sort(tokens);
        while(l<=r){
            if(power>=tokens[l]){
                count++;
                power-=tokens[l];
                l++;
                ans = Math.max(count,ans);
            }
            else if(count > 0){
                power+=tokens[r];
                count--;
                r--;
            }
            else break;
        }
        return ans;
    }
}