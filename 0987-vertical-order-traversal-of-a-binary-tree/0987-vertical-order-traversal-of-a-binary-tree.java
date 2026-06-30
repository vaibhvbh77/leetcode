class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // node new int[]{r, c, v}, sort Priority : c, r, v
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> 
                                                          o1[1] != o2[1] ? o1[1] - o2[1] :
                                                          o1[0] != o2[0] ? o1[0] - o2[0] : o1[2] - o2[2]);
        // 1. get nodes
        dfs(root, 0, 0, pq);
        // 2. get result
        List<List<Integer>> ret = new ArrayList<>();
        int pr = -1010;
        int pc = -1010;
        List<Integer> last = new ArrayList<>();
        
        // same col
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int cr = node[0];
            int cc = node[1];
            int cv = node[2];
            
            if((cc == pc) || (pr == -1010 && pc == -1010)){
                last.add(cv);
            }else{
                ret.add(new ArrayList<>(last));
                last.clear();
                last.add(cv);
            }
                            
            pr = cr;
            pc = cc;
        }
        
        if(last.size() > 0) ret.add(last);
        
        return ret;
    } 
    
    private void dfs(TreeNode root, int r, int c, PriorityQueue<int[]> pq){
        if(root == null) return;
        
        pq.offer(new int[]{r, c, root.val});
        
        dfs(root.left, r + 1, c - 1, pq);
        dfs(root.right, r + 1, c + 1, pq);
    }}