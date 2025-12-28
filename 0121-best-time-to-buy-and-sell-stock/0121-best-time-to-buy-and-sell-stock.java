class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;
        int n = prices.length;
        for(int i = 0;i<n;i++){
            if(min_price>prices[i]) min_price = prices[i];
            int profit = prices[i] - min_price;
            max_profit = Math.max(profit,max_profit);
        }
        return max_profit;
    }
}