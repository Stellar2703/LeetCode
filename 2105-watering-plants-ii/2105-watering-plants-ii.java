class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l=0,r=plants.length-1;
        int count =0;
        int a = capacityA;
        int b = capacityB;
        while(l<=r){
            if(l==r){
                if(a>=plants[l]||b>=plants[l]){
                    break;
                }
                count++;
                break;
            }
            if(a>=plants[l]){
                a-=plants[l];
            }
            else{
                count++;
                a = capacityA;
                a-=plants[l];
            }
            l++;
            if(b>=plants[r]){
                b-=plants[r];
            }
            else{
                count++;
                b = capacityB;
                b-=plants[r];
            }
            r--;
        }
        return count;
    }
}