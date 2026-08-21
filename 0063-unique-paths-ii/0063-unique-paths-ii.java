class Solution {
    int [][]dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            dp=new int[obstacleGrid.length][obstacleGrid[0].length];
             for(int []arr:dp){
            Arrays.fill(arr,-1);
        }

        return dfs(obstacleGrid,0,0);
    }
        public int dfs(int [][]grid,int currRow, int currCol){

        // outside grid
        int m=grid.length;
        int n=grid[0].length;

        if(currRow>=m || currCol>=n || grid[currRow][currCol]==1){
            return 0;
        }

        if(currRow==m-1 && currCol==n-1) return 1;

        if(dp[currRow][currCol]!=-1){
            return dp[currRow][currCol];
        }

        // down
        int down=dfs(grid,currRow+1,currCol);

        // right
        int right=dfs(grid,currRow,currCol+1);

        dp[currRow][currCol]= down+right;

        return dp[currRow][currCol];


    }
}