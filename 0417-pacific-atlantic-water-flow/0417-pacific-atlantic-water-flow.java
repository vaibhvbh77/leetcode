class Solution {
    List<List<Integer>>list;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        list =new ArrayList<>();
        boolean [][]pacific=new boolean [heights.length][heights[0].length];
        boolean [][]atlantic=new boolean [heights.length][heights[0].length];

// top row
        for(int i=0;i<heights[0].length;i++){
            dfs(heights,0,i,pacific);
        }


// leftcol
        for(int i=0;i<heights.length;i++){
            dfs(heights,i,0,pacific);
        }
        // right bottom

        for(int i=0;i<heights[0].length;i++){
            dfs(heights,heights.length-1,i,atlantic);
        }

                // colm right

        for(int i=0;i<heights.length;i++){
            dfs(heights,i,heights[0].length-1,atlantic);
        }

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer>ans=new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    list.add(ans);
                }
            }
        }

        return list;




    }
    public void dfs(int[][]heights,int row,int col,boolean[][]visited)
    {
        if(visited[row][col])return;

// why so sure ? cause we are doing this for only those which are our ans for sure
        visited[row][col]=true;

        // up 
        if(row-1>=0 && heights[row-1][col]>=heights[row][col]){
            dfs(heights,row-1,col,visited);
        }
         
             // down 
        if(row+1<heights.length && heights[row+1][col]>=heights[row][col]){
            dfs(heights,row+1,col,visited);
        }

            // left 
        if(col-1>=0 && heights[row][col-1]>=heights[row][col]){
            dfs(heights,row,col-1,visited);
        }

            // right 
        if(col+1<heights[0].length && heights[row][col+1]>=heights[row][col]){
            dfs(heights,row,col+1,visited);
        }

    }
}
