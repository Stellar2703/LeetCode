class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxi = piles[0];
        for (int i=0;i<n;i++){
            maxi = Math.max(maxi,piles[i]);
        }
        int lo = 1,hi = maxi;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            int time = 0;
            for (int i=0;i<n;i++){
                time+= Math.ceil((double)piles[i]/mid)  ;  
            }
            if(time>h){
                lo = mid+1;
            }else{
                hi = mid -1;
            }
        }
        return lo;
    }
}