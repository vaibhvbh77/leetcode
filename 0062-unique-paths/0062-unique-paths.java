class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int []arr:dp){
            Arrays.fill(arr,-1);
        }

        return dfs(m,n,0,0);
    }
    public int dfs(int m,int n, int currRow,int currCol){

        // outside grid

        if(currRow>=m || currCol>=n){
            return 0;
        }

        if(currRow==m-1 && currCol==n-1) return 1;

        if(dp[currRow][currCol]!=-1){
            return dp[currRow][currCol];
        }

        // down
        int down=dfs(m,n,currRow+1,currCol);

        // right
        int right=dfs(m,n,currRow,currCol+1);

        dp[currRow][currCol]= down+right;

        return dp[currRow][currCol];


    }
}