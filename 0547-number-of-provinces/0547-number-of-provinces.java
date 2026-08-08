class Solution {
    public int findCircleNum(int[][] isConnected) {
        
         int res=0;
        boolean []visited=new boolean[isConnected.length];

        
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                dfs(isConnected,visited,i);
                res++;
            }
        }
        return res;
    }
    public void dfs(int[][]adj,boolean []visited,int node){
        visited[node]=true;

        for(int i=0;i<adj[0].length;i++){
            if(!visited[i] &&adj[node][i] == 1 ){
               dfs(adj,visited,i); 
            }
        }

    }
}