class Solution {
    int dp[][];
    public int minimumTotal(List<List<Integer>> triangle) {

       int n = triangle.size();
        dp = new int[n][n];

        for(int[]arr:dp)
        Arrays.fill(arr,Integer.MAX_VALUE);

        return solve(triangle,0,0);

    }
    public int solve(List<List<Integer>>arr,int row,int col){
        // if row ans colms goes out of bound
        if(row==arr.size()-1){
        return arr.get(row).get(col);
        }

        if(dp[row][col]!=Integer.MAX_VALUE)return dp[row][col];


        int stable=solve(arr,row+1,col);

         int move=solve(arr,row+1,col+1);

         dp[row][col]= arr.get(row).get(col)+Math.min(stable,move);

        return dp[row][col];
    }
}