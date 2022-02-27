class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        ArrayList<Pair<Integer,TreeNode>> list = new ArrayList<Pair<Integer,TreeNode>>();
        
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        
        list.add(new Pair(1,root));
        int max = 1;
        
        
        while(!list.isEmpty()){
            
            // System.out.println(list);
            
            int len = list.size();
            Pair ps = list.get(0);
            Pair pe = list.get(len-1);
            
            int startval = (int)ps.getKey();
            int endval = (int)pe.getKey();
            
            max = Math.max(max,endval-startval+1);
            
            
            for(int i = 0 ; i < len ; i++){
                
                Pair p = list.get(0);
                list.remove(0);
                
                TreeNode node = (TreeNode)p.getValue();
                int ind = (int)p.getKey();
                
                if(node.left != null){
                    
                    Pair newpl = new Pair(ind*2,node.left);
                    list.add(newpl);
                }
                
                if(node.right != null){
                    
                    Pair newpr = new Pair(ind*2+1,node.right);
                    list.add(newpr);
                }
            }
            
        }
        
        return max;
        
    }
}