class Solution {
    int dp[][];
    public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        dp=new int[row+1][col+1];

        for(int i[]:dp)
        Arrays.fill(i,Integer.MAX_VALUE);


        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++)
        min=Math.min(min,solve(matrix,0,i));

        return min;
    }
    public int solve(int[][] matrix,int row,int col){
        if(col < 0 || col >= matrix[0].length){
            return Integer.MAX_VALUE;
        }
        if(row==matrix.length-1){
            return matrix[row][col];
        }

        if(dp[row][col]!=Integer.MAX_VALUE)
        return dp[row][col];

           int down=solve(matrix,row+1,col);
           int diagonalLeft=solve(matrix,row+1,col-1);
           int diagonalRight=solve(matrix,row+1,col+1);


    dp[row][col]= matrix[row][col] +
       Math.min(down, Math.min(diagonalLeft, diagonalRight));

       return dp[row][col];


    }
}