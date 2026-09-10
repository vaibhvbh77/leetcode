class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>q=new ArrayDeque<>();
        int minutes=0;
        int fresh=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        while(q.isEmpty()==false){
            // 

            int size=q.size();

            for(int i=0;i<size;i++){

            int []curr=q.poll();
            int row=curr[0];
            int col=curr[1];
                // up
                if(row-1>=0 && grid[row-1][col]==1){
                    grid[row-1][col]=2;
                    fresh--;
                    q.offer(new int[]{row-1,col});
                }

                        // down
                if(row+1<grid.length && grid[row+1][col]==1){
                    grid[row+1][col]=2;
                    fresh--;
                    q.offer(new int[]{row+1,col});
                }

                       // right
                if(col+1<grid[0].length && grid[row][col+1]==1){
                    grid[row][col+1]=2;
                    fresh--;
                    q.offer(new int[]{row,col+1});
                }

                        // left
                if(col-1>=0 && grid[row][col-1]==1){
                    grid[row][col-1]=2;
                    fresh--;
                    q.offer(new int[]{row,col-1});
                }
            }
              if(!q.isEmpty()){
                minutes++;
            }
        }

        return fresh==0?minutes:-1;
    }
}