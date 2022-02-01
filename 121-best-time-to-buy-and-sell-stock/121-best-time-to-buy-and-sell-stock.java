class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int l=Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length-1;i++){
            l=Math.min(prices[i],l);
            max=Math.max(prices[i+1]-l,max);
            
        }
        
        return max;
    }
}