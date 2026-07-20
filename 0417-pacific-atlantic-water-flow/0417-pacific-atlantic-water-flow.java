class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][]pacific=new boolean[heights.length][heights[0].length];
        boolean[][]atlantic=new boolean[heights.length][heights[0].length];
        List<List<Integer>>list=new ArrayList<>();


//       Top row
        for(int i=0;i<heights[0].length;i++){
            // for pacific[0][i]
            dfs(heights, 0, i, pacific);
        }

//       left column
        for(int i=0;i<heights.length;i++){
            // for pacific[i][0]
            dfs(heights, i, 0, pacific);
        }

//       right column
        for(int i=0;i<heights.length;i++){
            // for pacific[i][heights[0].length-1]
            dfs(heights, i, heights[0].length-1, atlantic);
        }


//       bottom row
        for(int i=0;i<=heights[0].length-1;i++){
            // for pacific[hieghts.length-1][i]
            dfs(heights, heights.length-1,i, atlantic);
        }


        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }
    public void dfs(int[][] heights,int row,int col,boolean[][]visited){
       if (row < 0 || row >= heights.length ||
    col < 0 || col >= heights[0].length) {
    return;
}
if (visited[row][col]) {
    return;
}
visited[row][col]=true;

if (row + 1 < heights.length &&
    heights[row + 1][col] >= heights[row][col]) {
    dfs(heights, row + 1, col, visited);
}

if (row - 1 >=0 &&
    heights[row - 1][col] >= heights[row][col]) {
    dfs(heights, row - 1, col, visited);
}

if (col - 1 >=0 &&
    heights[row][col-1] >= heights[row][col]) {
    dfs(heights, row , col-1, visited);
}
if (col + 1 <heights[0].length &&
    heights[row ][col+1] >= heights[row][col]) {
    dfs(heights, row , col+1, visited);
}
    }
}
