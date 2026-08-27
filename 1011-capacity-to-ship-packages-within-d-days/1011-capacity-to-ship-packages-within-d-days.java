class Solution {
    public boolean f(int[] weights,int days,int cap){
        int n = weights.length;
        int day = 1,load = 0;
        for(int i =0;i<n;i++){
            if(load+weights[i]>cap){
                load = weights[i];
                day+=1;
            }
            else{
                load+=weights[i];
            }
        }
        return day<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = 0,max=0;
        for(int i=0;i<n;i++){
            max = Math.max(weights[i],max);
            sum+=weights[i];
        }

        int l = max,r = sum;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(f(weights,days,mid)){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}