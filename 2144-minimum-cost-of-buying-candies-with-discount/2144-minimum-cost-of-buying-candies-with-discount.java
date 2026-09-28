class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int ans = 0;
        int pos = 1;

        for (int i = cost.length - 1; i >= 0; i--) {
            if(pos%3!=0){
                ans+=cost[i];
            }
            pos++;
        }

        return ans;
    }
}