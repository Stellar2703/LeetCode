class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int min = Integer.MAX_VALUE;
        int ind = -1;

        for(int i =0;i<capacity.length;i++){
            if(capacity[i]>=itemSize){
                if(min>capacity[i]){
                    min = capacity[i];
                    ind = i;
                }
            }
        }
        return ind;
    }
}