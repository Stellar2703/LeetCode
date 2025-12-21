class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0 , max_sum=0;
        for (int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int n = cardPoints.length;
        int l=k-1;
        int r=n-1;
        max_sum = Math.max(sum,max_sum);
        while(l>=0){
            sum-=cardPoints[l];
            sum+=cardPoints[r];
            l--;
            r--;
            max_sum=Math.max(sum,max_sum);
        }
        return max_sum;
    }
}