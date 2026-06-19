class Solution {
    public int largestAltitude(int[] gain) {
        int c = 0,max =0;
        for(int g : gain){
            c+=g;
            max = Math.max(max,c);
        }
        return max;
    }
}