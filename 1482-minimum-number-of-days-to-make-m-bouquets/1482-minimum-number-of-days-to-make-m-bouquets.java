class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int maxi = bloomDay[0];
        if(n < ((long)m*k)){
            return -1;
        }
        for(int i=0; i<n;i++){
            maxi = Math.max(maxi,bloomDay[i]);
        }
        int l = 1,r=maxi;
        while (l<=r){
        // for (int day = 1;day<=maxi;day++){
            int day  = (l+r)/2;
            int b=0, flower = 0;
            for (int i=0;i<n;i++){
                if (bloomDay[i]<= day){
                    flower++;
                    if(flower == k){
                        b+=1;
                        flower = 0;
                    }
                }
                else{
                        flower = 0;
                    }
            }
            if(b>=m){
                r = day-1;
            }
            else{
                l = day+1;
            }
        }
        return l;
    }
}