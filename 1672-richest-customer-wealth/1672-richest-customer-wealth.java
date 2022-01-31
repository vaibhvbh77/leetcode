class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        for(int i=0;i<accounts.length;i++){
            int l=0;
            for(int j=0;j<accounts[0].length;j++){
                l+=accounts[i][j];
            }
            max=Math.max(l,max);
        }
        return max;
    }
}