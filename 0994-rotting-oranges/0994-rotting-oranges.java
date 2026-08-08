class Solution {
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]>q=new ArrayDeque<>();
        int minutes=0;
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                 if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        while(q.isEmpty()==false && fresh>0){
            int size=q.size();

        for(int i=0;i<size;i++){
            int []rotten=q.poll();
            int row=rotten[0];
            int column=rotten[1];
            grid[row][column]=2;

            // up 
            if(row-1>=0 &&grid[row-1][column]==1){
                grid[row-1][column] = 2;
                fresh--;
                q.offer(new int[]{row-1,column});
            }


                // down 
            if( row+1<grid.length &&grid[row+1][column]==1){
                grid[row+1][column] = 2;
                fresh--;
                q.offer(new int[]{row+1,column});
            }

                // left 
            if(column-1>=0 &&grid[row][column-1]==1){
                grid[row][column-1] = 2;
                fresh--;
                q.offer(new int[]{row,column-1});
            }

                // right 
            if(column+1<grid[0].length &&grid[row][column+1]==1){
                grid[row][column+1] = 2;
                fresh--;
                q.offer(new int[]{row,column+1});
            }
            }
            minutes++;

        }
        

        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        if(fresh==0)return minutes;
        return -1;



    }
    }
