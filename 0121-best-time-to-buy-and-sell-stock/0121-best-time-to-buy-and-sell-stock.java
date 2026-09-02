class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int minimumBuyingPrice=prices[0];
        int size=prices.length;

        for(int i=1;i<size;i++){
            int localProfit=prices[i]-minimumBuyingPrice;
            profit=Math.max(localProfit,profit);
            minimumBuyingPrice=Math.min(minimumBuyingPrice,prices[i]);
        }



        return profit;
        
        
    }
}